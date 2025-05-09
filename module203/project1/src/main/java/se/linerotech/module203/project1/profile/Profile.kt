package se.linerotech.module203.project1.profile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module203.project1.common.Book

@Parcelize
data class Profile(
    val profileName: String,
    val profileImage: String,
    val bookCount: Int,
    val collections: Int,
    val recentlyAddedList: List<Book>,
    val recentlyReadList: List<Book>,
    val favoriteList: List<Book>
) : Parcelable {
    constructor(dto: ProfileDTO) : this(
        profileName = dto.name ?: "Unknown name",
        profileImage = dto.image ?: "Unknown image",
        bookCount = dto.bookCount ?: 0,
        collections = dto.collections ?: 0,
        recentlyAddedList = dto.recentlyAdded
            ?.mapNotNull { it?.toBook() } ?: emptyList(),
        recentlyReadList = dto.recentlyRead
            ?.mapNotNull { it?.toBook() } ?: emptyList(),
        favoriteList = dto.favorite
            ?.mapNotNull { it?.toBook() } ?: emptyList()
    )
}
