package se.linerotech.module203.guide.cars.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CarDto(
    @Json(name = "details")
    val details: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price_per_day")
    val pricePerDay: Int,
    @Json(name = "seat")
    val seat: Int,
    @Json(name = "transmission")
    val transmission: String
)
