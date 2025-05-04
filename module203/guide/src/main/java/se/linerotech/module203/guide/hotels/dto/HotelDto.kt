package se.linerotech.module203.guide.hotels.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HotelDto(
    @Json(name = "details")
    val details: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price_per_night")
    val pricePerNight: Int,
    @Json(name = "reviews")
    val reviews: Int,
    @Json(name = "stars")
    val stars: Int
)
