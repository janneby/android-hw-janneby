package se.linerotech.module203.project1.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.project1.discover.dto.DiscoverDTO

@Parcelize
data class Book(
    val image: String,
    val title: String,
    val author: String,
    val averageRating: Double,
    val ratingCount: Int,
    val pageCount: Int,
    val publicationDate: String,
    val isbn: String,
    val description: String,
) : Parcelable {
    constructor(dto: DiscoverDTO.Book) : this(
        image = dto.image ?: "Unknown image",
        title = dto.title ?: "Unknown Title",
        author = dto.author ?: "Unknown Author",
        averageRating = dto.averageRating ?: 0.0,
        ratingCount = dto.ratingCount ?: 0,
        pageCount = dto.pageCount ?: 0,
        publicationDate = dto.publicationDate ?: "Unknown Date",
        isbn = dto.isbn ?: "Unknown ISBN",
        description = dto.description ?: "Unknown Description"
    )
}
