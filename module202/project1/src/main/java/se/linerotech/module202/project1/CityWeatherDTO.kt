package se.linerotech.module202.project1

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityWeatherDTO(
    @Json(name = "location")
    val location: Location? = Location(),
    @Json(name = "current")
    val current: Current? = Current()
) {
    @JsonClass(generateAdapter = true)
    data class Location(
        @Json(name = "name")
        val name: String? = "",
        @Json(name = "region")
        val region: String? = "",
        @Json(name = "country")
        val country: String? = "",
        @Json(name = "lat")
        val lat: Double? = 0.0,
        @Json(name = "lon")
        val lon: Double? = 0.0,
        @Json(name = "tz_id")
        val tzId: String? = "",
        @Json(name = "localtime_epoch")
        val localtimeEpoch: Int? = 0,
        @Json(name = "localtime")
        val localtime: String? = ""
    )

    @JsonClass(generateAdapter = true)
    data class Current(
        @Json(name = "last_updated_epoch")
        val lastUpdatedEpoch: Int? = 0,
        @Json(name = "last_updated")
        val lastUpdated: String? = "",
        @Json(name = "temp_c")
        val tempC: Double? = 0.0,
        @Json(name = "temp_f")
        val tempF: Double? = 0.0,
        @Json(name = "is_day")
        val isDay: Int? = 0,
        @Json(name = "condition")
        val condition: Condition? = Condition(),
        @Json(name = "wind_mph")
        val windMph: Double? = 0.0,
        @Json(name = "wind_kph")
        val windKph: Double? = 0.0,
        @Json(name = "wind_degree")
        val windDegree: Int? = 0,
        @Json(name = "wind_dir")
        val windDir: String? = "",
        @Json(name = "pressure_mb")
        val pressureMb: Double? = 0.0,
        @Json(name = "pressure_in")
        val pressureIn: Double? = 0.0,
        @Json(name = "precip_mm")
        val precipMm: Double? = 0.0,
        @Json(name = "precip_in")
        val precipIn: Double? = 0.0,
        @Json(name = "humidity")
        val humidity: Int? = 0,
        @Json(name = "cloud")
        val cloud: Int? = 0,
        @Json(name = "feelslike_c")
        val feelslikeC: Double? = 0.0,
        @Json(name = "feelslike_f")
        val feelslikeF: Double? = 0.0,
        @Json(name = "windchill_c")
        val windchillC: Double? = 0.0,
        @Json(name = "windchill_f")
        val windchillF: Double? = 0.0,
        @Json(name = "heatindex_c")
        val heatindexC: Double? = 0.0,
        @Json(name = "heatindex_f")
        val heatindexF: Double? = 0.0,
        @Json(name = "dewpoint_c")
        val dewpointC: Double? = 0.0,
        @Json(name = "dewpoint_f")
        val dewpointF: Double? = 0.0,
        @Json(name = "vis_km")
        val visKm: Double? = 0.0,
        @Json(name = "vis_miles")
        val visMiles: Double? = 0.0,
        @Json(name = "uv")
        val uv: Double? = 0.0,
        @Json(name = "gust_mph")
        val gustMph: Double? = 0.0,
        @Json(name = "gust_kph")
        val gustKph: Double? = 0.0
    ) {
        @JsonClass(generateAdapter = true)
        data class Condition(
            @Json(name = "text")
            val text: String? = "",
            @Json(name = "icon")
            val icon: String? = "",
            @Json(name = "code")
            val code: Int? = 0
        )
    }
}
