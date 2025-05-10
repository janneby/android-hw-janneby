package se.linerotech.module203.project2.incidents.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IncidentDTO(
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "datetime")
    val datetime: String? = "",
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "summary")
    val summary: String? = "",
    @Json(name = "url")
    val url: String? = "",
    @Json(name = "type")
    val type: String? = "",
    @Json(name = "location")
    val location: Location? = Location()
) {
    @JsonClass(generateAdapter = true)
    data class Location(
        @Json(name = "name")
        val name: String? = "",
        @Json(name = "gps")
        val gps: String? = ""
    )
}
