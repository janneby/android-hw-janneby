package se.linerotech.module203.guide.hotels.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HotelDataDto(
    @Json(name = "hotels")
    val hotelDtos: List<HotelDto>
)
