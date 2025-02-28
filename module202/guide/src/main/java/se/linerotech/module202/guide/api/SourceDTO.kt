package se.linerotech.module202.guide.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourceDTO(
    @Json(name = "source_id")
    val id: String? = "",
    @Json(name = "source_name")
    val name: String? = ""
)
