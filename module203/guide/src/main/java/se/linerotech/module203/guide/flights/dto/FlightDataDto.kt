package se.linerotech.module203.guide.flights.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlightDataDto(
    @Json(name = "flights")
    val flightDtos: List<FlightDto>
)
