package se.linerotech.module203.project2.common

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import se.linerotech.module203.project2.stations.Station
import java.io.File
import java.io.IOException

object GeoJsonUtils {
    fun saveStationsToGeoJson(
        stations: List<Station>,
        context: Context,
        fileName: String = "police_stations.geojson"
    ) {
        try {
            // Create GeoJSON FeatureCollection
            val featureCollection = JSONObject().apply {
                put("type", "FeatureCollection")
                put(
                    "features",
                    JSONArray().apply {
                        stations.forEach { station ->
                            // Parse GPS coordinates
                            val gpsParts = station.location.gps.split(",")
                            if (gpsParts.size == 2) {
                                val latitude = gpsParts[0].trim().toDoubleOrNull()
                                val longitude = gpsParts[1].trim().toDoubleOrNull()
                                if (latitude != null && longitude != null) {
                                    // Create a Feature for each station
                                    val feature = JSONObject().apply {
                                        put("type", "Feature")
                                        put(
                                            "geometry",
                                            JSONObject().apply {
                                                put("type", "Point")
                                                put(
                                                    "coordinates",
                                                    JSONArray().apply {
                                                        put(longitude) // GeoJSON uses [longitude, latitude]
                                                        put(latitude)
                                                    }
                                                )
                                            }
                                        )
                                        put(
                                            "properties",
                                            JSONObject().apply {
                                                put("id", station.id)
                                                put("name", station.name)
                                                put("url", station.url)
                                                put("location_name", station.location.name)
                                                put("services", JSONArray(station.services.map { it.name }))
                                            }
                                        )
                                    }
                                    put(feature)
                                }
                            }
                        }
                    }
                )
            }

            // Convert to formatted JSON string
            val geoJsonString = featureCollection.toString(2) // Indented with 2 spaces

            // Save to file in internal storage
            val file = File(context.filesDir, fileName)
            file.writeText(geoJsonString, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            // Handle file writing error (e.g., log or notify user)
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            // Handle invalid GPS format
        }
    }

    fun readGeoJson(context: Context, fileName: String = "police_stations.geojson"): String? {
        return try {
            val file = File(context.filesDir, fileName)
            if (file.exists()) file.readText(Charsets.UTF_8) else null
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
