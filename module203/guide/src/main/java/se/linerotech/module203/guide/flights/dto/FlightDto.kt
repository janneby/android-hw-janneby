package se.linerotech.module203.guide.flights.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlightDto(
    @Json(name = "from")
    val from: String = "",
    @Json(name = "to")
    val to: String = "",
    @Json(name = "duration_in_hours")
    val durationInHours: Int = 0,
    @Json(name = "departure")
    val departure: String = "",
    @Json(name = "arrival")
    val arrival: String = "",
    @Json(name = "price")
    val price: Double = 0.0,
    @Json(name = "stops")
    val stops: Int = 0
)
