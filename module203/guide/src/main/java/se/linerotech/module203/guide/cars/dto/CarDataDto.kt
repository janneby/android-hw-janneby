package se.linerotech.module203.guide.cars.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CarDataDto(
    @Json(name = "cars")
    val carDtos: List<CarDto>
)
