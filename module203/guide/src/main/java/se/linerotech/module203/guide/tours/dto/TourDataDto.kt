package se.linerotech.module203.guide.tours.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TourDataDto(
    @Json(name = "tours")
    val tourDtos: List<TourDto>
)
