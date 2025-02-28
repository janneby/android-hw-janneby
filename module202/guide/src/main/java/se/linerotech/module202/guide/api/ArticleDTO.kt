package se.linerotech.module202.guide.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleDTO(
    @Json(name = "ai_org")
    val aiOrg: String? = "",
    @Json(name = "ai_region")
    val aiRegion: String? = "",
    @Json(name = "ai_tag")
    val aiTag: String? = "",
    @Json(name = "article_id")
    val articleId: String? = "",
    @Json(name = "category")
    val category: List<String?>? = listOf(),
    @Json(name = "content")
    val content: String? = "",
    @Json(name = "country")
    val country: List<String?>? = listOf(),
    @Json(name = "creator")
    val creator: List<String?>? = listOf(),
    @Json(name = "description")
    val description: String? = "",
    @Json(name = "duplicate")
    val duplicate: Boolean? = false,
    @Json(name = "image_url")
    val imageUrl: String? = "",
    @Json(name = "keywords")
    val keywords: List<String?>? = listOf(),
    @Json(name = "language")
    val language: String? = "",
    @Json(name = "link")
    val link: String? = "",
    @Json(name = "pubDate")
    val pubDate: String? = "",
    @Json(name = "pubDateTZ")
    val pubDateTZ: String? = "",
    @Json(name = "sentiment")
    val sentiment: String? = "",
    @Json(name = "sentiment_stats")
    val sentimentStats: String? = "",
    @Json(name = "source_icon")
    val sourceIcon: String? = "",
    @Json(name = "source_id")
    val sourceId: String? = "",
    @Json(name = "source_name")
    val sourceName: String? = "",
    @Json(name = "source_priority")
    val sourcePriority: Int? = 0,
    @Json(name = "source_url")
    val sourceUrl: String? = "",
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "video_url")
    val videoUrl: Any? = Any()
)
