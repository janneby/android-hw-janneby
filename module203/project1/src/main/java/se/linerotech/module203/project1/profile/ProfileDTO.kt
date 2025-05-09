package se.linerotech.module203.project1.profile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import se.linerotech.module203.project1.common.Book

@JsonClass(generateAdapter = true)
data class ProfileDTO(
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "image")
    val image: String? = "",
    @Json(name = "book_count")
    val bookCount: Int? = 0,
    @Json(name = "collections")
    val collections: Int? = 0,
    @Json(name = "recently_added")
    val recentlyAdded: List<RecentlyAdded?>? = listOf(),
    @Json(name = "recently_read")
    val recentlyRead: List<RecentlyRead?>? = listOf(),
    @Json(name = "favorite")
    val favorite: List<Favorite?>? = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class RecentlyAdded(
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

    @JsonClass(generateAdapter = true)
    data class RecentlyRead(
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

    @JsonClass(generateAdapter = true)
    data class Favorite(
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

fun ProfileDTO.RecentlyAdded.toBook(): Book {
    return Book(
        image = this.image ?: "Unknown image",
        title = this.title ?: "Unknown Title",
        author = this.author ?: "Unknown Author",
        averageRating = this.averageRating ?: 0.0,
        ratingCount = this.ratingCount ?: 0,
        pageCount = this.pageCount ?: 0,
        publicationDate = this.publicationDate ?: "Unknown Date",
        isbn = this.isbn ?: "Unknown ISBN",
        description = this.description ?: "Unknown Description"
    )
}

fun ProfileDTO.RecentlyRead.toBook(): Book {
    return Book(
        image = this.image ?: "Unknown image",
        title = this.title ?: "Unknown Title",
        author = this.author ?: "Unknown Author",
        averageRating = this.averageRating ?: 0.0,
        ratingCount = this.ratingCount ?: 0,
        pageCount = this.pageCount ?: 0,
        publicationDate = this.publicationDate ?: "Unknown Date",
        isbn = this.isbn ?: "Unknown ISBN",
        description = this.description ?: "Unknown Description"
    )
}

fun ProfileDTO.Favorite.toBook(): Book {
    return Book(
        image = this.image ?: "Unknown image",
        title = this.title ?: "Unknown Title",
        author = this.author ?: "Unknown Author",
        averageRating = this.averageRating ?: 0.0,
        ratingCount = this.ratingCount ?: 0,
        pageCount = this.pageCount ?: 0,
        publicationDate = this.publicationDate ?: "Unknown Date",
        isbn = this.isbn ?: "Unknown ISBN",
        description = this.description ?: "Unknown Description"
    )
}
