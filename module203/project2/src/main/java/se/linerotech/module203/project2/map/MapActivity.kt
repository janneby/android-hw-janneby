package se.linerotech.module203.project2.map

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.PuckBearing
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.mapbox.maps.plugin.gestures.addOnMapClickListener
import com.mapbox.maps.plugin.locationcomponent.createDefault2DPuck
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.plugin.viewport.viewport
import org.json.JSONArray
import org.json.JSONObject
import se.linerotech.module203.project2.R
import se.linerotech.module203.project2.common.GeoJsonUtils
import se.linerotech.module203.project2.databinding.ActivityMapBinding
import se.linerotech.module203.project2.stations.Station

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding
    private lateinit var permissionsManager: PermissionsManager
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private var currentStationUrl: String? = null // Store the URL of the currently displayed station
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener for CardView to open station URL
        binding.stationCard.setOnClickListener {
            Log.d("MapActivity", "StationCard clicked, attempting to open URL: $currentStationUrl")
            currentStationUrl?.let { url ->
                showStationDetail(url)
            } ?: run {
                Log.w("MapActivity", "No URL available for the current station")
                Toast.makeText(this, "No URL available for this station", Toast.LENGTH_SHORT).show()
            }
        }

        // Read GeoJSON file
        val geoJsonContent = GeoJsonUtils.readGeoJson(this)
        Log.d("MapActivity", "GeoJSON Content: ${geoJsonContent ?: "null"}")

        // Initialize BottomSheetBehavior for the FrameLayout
        binding.bottomSheetContainer.post {
            bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetContainer)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            bottomSheetBehavior.peekHeight = 200 // in pixels
            bottomSheetBehavior.isHideable = true
            binding.stationCard.elevation = 8f

            // Log BottomSheetBehavior state for debugging
            bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    Log.d("MapActivity", "BottomSheet state: $newState")
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    Log.d("MapActivity", "BottomSheet slide offset: $slideOffset")
                }
            })
        }

        setupToolbar()
        configureMapView(geoJsonContent)
    }

    private fun configureMapView(geoJsonContent: String?) {
        with(binding.mapView) {
            mapboxMap.loadStyleUri(Style.MAPBOX_STREETS) { style ->
                // Load marker image
                var markerImageId = R.drawable.station_icon
                var markerBitmap: Bitmap? = try {
                    val drawable = ContextCompat.getDrawable(this@MapActivity, markerImageId)
                    drawable?.toBitmap(48, 48)
                } catch (e: Exception) {
                    Log.w("MapActivity", "Failed to load vector drawable: ${e.message}")
                    null
                }

                if (markerBitmap == null) {
                    Log.w("MapActivity", "Using fallback marker")
                    markerImageId = android.R.drawable.ic_menu_myplaces
                    markerBitmap = BitmapFactory.decodeResource(resources, markerImageId)
                }

                try {
                    if (markerBitmap != null) {
                        style.addImage(markerImageId.toString(), markerBitmap)
                        val annotationApi = annotations
                        val pointAnnotationManager = annotationApi.createPointAnnotationManager()

                        // Parse GeoJSON and add points
                        val stations = mutableListOf<Station>()
                        if (geoJsonContent != null) {
                            try {
                                val jsonObject = JSONObject(geoJsonContent)
                                val features = jsonObject.getJSONArray("features")
                                Log.d("MapActivity", "GeoJSON Features Count: ${features.length()}")
                                for (i in 0 until features.length()) {
                                    val feature = features.getJSONObject(i)
                                    val geometry = feature.getJSONObject("geometry")
                                    val coordinates = geometry.getJSONArray("coordinates")
                                    val longitude = coordinates.getDouble(0)
                                    val latitude = coordinates.getDouble(1)
                                    val properties = feature.getJSONObject("properties")
                                    val id = properties.optInt("id", 0)
                                    val name = properties.optString("name", "Unknown Station")
                                    val url = properties.optString("url", "")
                                    val locationName = properties.optString("location_name", "No address")
                                    val servicesArray = properties.optJSONArray("services") ?: JSONArray()
                                    val services = mutableListOf<Station.Service>()
                                    for (j in 0 until servicesArray.length()) {
                                        services.add(Station.Service(servicesArray.getString(j)))
                                    }

                                    // Create Station object
                                    val station = Station(
                                        id = id,
                                        name = name,
                                        url = url,
                                        location = Station.Location(
                                            name = locationName,
                                            gps = "$latitude,$longitude"
                                        ),
                                        services = services
                                    )
                                    stations.add(station)
                                    Log.d("MapActivity", "Added Station: $name at ($latitude, $longitude)")

                                    // Convert Station to JsonElement
                                    val stationJson: JsonElement = JsonParser.parseString(gson.toJson(station))

                                    // Add annotation
                                    val point = Point.fromLngLat(longitude, latitude)
                                    val pointAnnotationOptions = PointAnnotationOptions()
                                        .withPoint(point)
                                        .withIconImage(markerImageId.toString())
                                        .withTextField(name)
                                        .withTextOffset(listOf(0.0, -2.0))
                                        .withData(stationJson) // Use JsonElement
                                    pointAnnotationManager.create(pointAnnotationOptions)
                                }
                            } catch (e: Exception) {
                                Log.e("MapActivity", "Error parsing GeoJSON: ${e.message}", e)
                                Toast.makeText(
                                    this@MapActivity,
                                    "Error parsing GeoJSON data",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Log.w("MapActivity", "GeoJSON file not found or empty")
                            Toast.makeText(
                                this@MapActivity,
                                "No GeoJSON data available",
                                Toast.LENGTH_SHORT
                            ).show()
                            // Fallback points
                            val points = listOf(
                                Point.fromLngLat(12.019758, 57.659398),
                                Point.fromLngLat(12.119758, 57.759398)
                            )
                            points.forEach { point ->
                                val pointAnnotationOptions = PointAnnotationOptions()
                                    .withPoint(point)
                                    .withIconImage(markerImageId.toString())
                                pointAnnotationManager.create(pointAnnotationOptions)
                            }
                        }

                        // Set click listener for annotations
                        pointAnnotationManager.addClickListener { annotation ->
                            Log.d("MapActivity", "Marker clicked, data: ${annotation.getData()}")
                            val jsonElement = annotation.getData()
                            if (jsonElement != null) {
                                try {
                                    // Convert JsonElement back to Station
                                    val station = gson.fromJson(jsonElement, Station::class.java)
                                    Log.d("MapActivity", "Station: $station")

                                    // Store the station URL
                                    currentStationUrl = station.url.takeIf { it.isNotEmpty() }

                                    // Ensure stationCard is visible
                                    binding.stationCard.visibility = View.VISIBLE

                                    // Populate CardView with fallback text
                                    binding.stationCard.findViewById<TextView>(R.id.textViewTitle).text =
                                        station.name.takeIf { it.isNotEmpty() } ?: "Unknown Station"
                                    binding.stationCard.findViewById<TextView>(R.id.textViewLocation).text =
                                        station.location.name.takeIf { it.isNotEmpty() } ?: "No address"
                                    binding.stationCard.findViewById<TextView>(R.id.textViewServices).text =
                                        station.services.joinToString(", ") { it.name }
                                            .takeIf { it.isNotEmpty() } ?: "No services"

                                    // Show bottom sheet
                                    Log.d("MapActivity", "Showing bottom sheet")
                                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                                } catch (e: Exception) {
                                    Log.e("MapActivity", "Error processing marker click: ${e.message}", e)
                                    Toast.makeText(
                                        this@MapActivity,
                                        "Error displaying station details",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Log.w("MapActivity", "No data attached to annotation")
                            }
                            true // Consume the click event
                        }

                        // Hide bottom sheet on map click (outside markers)
                        mapboxMap.addOnMapClickListener {
                            Log.d("MapActivity", "Map clicked, hiding bottom sheet")
                            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                            binding.stationCard.visibility = View.GONE
                            currentStationUrl = null // Clear URL when hiding
                            true
                        }

                        mapboxMap.triggerRepaint()
                    } else {
                        Log.e("MapActivity", "No valid marker image available")
                        Toast.makeText(
                            this@MapActivity,
                            "Marker image not found",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: Exception) {
                    Log.e("MapActivity", "Error loading marker: ${e.message}", e)
                    Toast.makeText(
                        this@MapActivity,
                        "Error loading marker: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            mapboxMap.setCamera(
                CameraOptions.Builder()
                    .center(Point.fromLngLat(11.96, 57.7))
                    .pitch(0.0)
                    .zoom(5.0)
                    .bearing(0.0)
                    .build()
            )

            // Check location permissions
            if (PermissionsManager.areLocationPermissionsGranted(this@MapActivity)) {
                enableLocationComponent()
            } else {
                permissionsManager = PermissionsManager(object : PermissionsListener {
                    override fun onExplanationNeeded(permissionsToExplain: List<String>) {
                        Toast.makeText(
                            this@MapActivity,
                            "Location permissions needed to show your position",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onPermissionResult(granted: Boolean) {
                        if (granted) {
                            enableLocationComponent()
                        } else {
                            Toast.makeText(
                                this@MapActivity,
                                "Location permissions denied.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })
                permissionsManager.requestLocationPermissions(this@MapActivity)
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Police Map"
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(this, R.color.darkslategray))
        )
    }

    private fun enableLocationComponent() {
        with(binding.mapView) {
            location.locationPuck = createDefault2DPuck(withBearing = true)
            location.enabled = true
            location.puckBearing = PuckBearing.COURSE
            location.puckBearingEnabled = true
            viewport.transitionTo(
                targetState = viewport.makeFollowPuckViewportState(),
                transition = viewport.makeImmediateViewportTransition()
            )
            mapboxMap.setCamera(
                CameraOptions.Builder()
                    .zoom(14.0)
                    .build()
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun showStationDetail(url: String) {
        val baseUrl = getString(R.string.https_polisen_se)
        val fullUrl = if (url.startsWith(getString(R.string.http))) url else "$baseUrl$url"
        Log.d("MapActivity", "Opening URL: $fullUrl")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fullUrl))
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Log.e("MapActivity", "Error opening URL: ${e.message}", e)
            Toast.makeText(this, "Unable to open URL", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
