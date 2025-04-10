package se.linerotech.module203.guide.tours.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TourDto(
    @Json(name = "days")
    val days: Int,
    @Json(name = "details")
    val details: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "location")
    val location: String,
    @Json(name = "price")
    val price: Int,
    @Json(name = "title")
    val title: String
)
