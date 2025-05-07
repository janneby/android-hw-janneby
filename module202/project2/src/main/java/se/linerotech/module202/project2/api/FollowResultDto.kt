package se.linerotech.module202.project2.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FollowResultDto(
    val items: List<FollowResultDtoItem> // No @Json annotation needed for raw array
)
