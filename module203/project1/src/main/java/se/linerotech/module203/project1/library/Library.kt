package se.linerotech.module203.project1.library

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.project1.common.Book

@Parcelize
data class Library(
    val categoryName: String,
    val bookList: List<Book>,
) : Parcelable {
    constructor(dto: LibraryDTO.Category) : this(
        categoryName = dto.name ?: "Unknown name",
        bookList = dto.books?.mapNotNull { bookDto ->
            bookDto?.let {
                Book(
                    image = it.image ?: "Unknown image",
                    title = it.title ?: "Unknown Title",
                    author = it.author ?: "Unknown Author",
                    averageRating = it.averageRating ?: 0.0,
                    ratingCount = it.ratingCount ?: 0,
                    pageCount = it.pageCount ?: 0,
                    publicationDate = it.publicationDate ?: "Unknown Date",
                    isbn = it.isbn ?: "Unknown ISBN",
                    description = it.description ?: "Unknown Description"
                )
            }
        } ?: emptyList()
    )
}
