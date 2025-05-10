package se.linerotech.module203.project2.stations.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StationDTO(
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "Url")
    val url: String? = "",
    @Json(name = "location")
    val location: Location? = Location(),
    @Json(name = "services")
    val services: List<Service?>? = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Location(
        @Json(name = "name")
        val name: String? = "",
        @Json(name = "gps")
        val gps: String? = ""
    )

    @JsonClass(generateAdapter = true)
    data class Service(
        @Json(name = "name")
        val name: String? = ""
    )
}
