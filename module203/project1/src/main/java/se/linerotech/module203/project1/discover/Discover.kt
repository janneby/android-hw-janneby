package se.linerotech.module203.project1.discover

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.project1.discover.dto.DiscoverDTO

@Parcelize
data class Discover(
    val title: String,
    val author: String? = null,
    val averageRating: Double? = null,
    val image: String? = null
    // Add other fields as needed
) : Parcelable {
    constructor(dto: DiscoverDTO.Book) : this(
        title = dto.title ?: "Unknown Title",
        author = dto.author,
        averageRating = dto.averageRating,
        image = dto.image
        // Map other fields as needed
    )
}