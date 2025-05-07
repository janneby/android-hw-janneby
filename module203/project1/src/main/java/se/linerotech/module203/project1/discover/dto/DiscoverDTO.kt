package se.linerotech.module203.project1.discover.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DiscoverDTO(
    @Json(name = "books")
    val books: List<Book?>? = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Book(
        @Json(name = "author")
        val author: String? = "",
        @Json(name = "averageRating")
        val averageRating: Double? = 0.0,
        @Json(name = "categories")
        val categories: List<String?>? = listOf(),
        @Json(name = "collectionId")
        val collectionId: String? = "",
        @Json(name = "dateAddedToFirebase")
        val dateAddedToFirebase: String? = "",
        @Json(name = "dateAddedToLocalDB")
        val dateAddedToLocalDB: String? = "",
        @Json(name = "description")
        val description: String? = "",
        @Json(name = "goodReadsBookId")
        val goodReadsBookId: String? = "",
        @Json(name = "image")
        val image: String? = "",
        @Json(name = "isFavorite")
        val isFavorite: Boolean? = false,
        @Json(name = "isLent")
        val isLent: Boolean? = false,
        @Json(name = "isRead")
        val isRead: Boolean? = false,
        @Json(name = "isbn")
        val isbn: String? = "",
        @Json(name = "pageCount")
        val pageCount: Int? = 0,
        @Json(name = "publicationDate")
        val publicationDate: String? = "",
        @Json(name = "publisher")
        val publisher: String? = "",
        @Json(name = "ratingCount")
        val ratingCount: Int? = 0,
        @Json(name = "title")
        val title: String? = ""
    )
}