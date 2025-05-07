package se.linerotech.module203.project1.library

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Library(
    val title: String,

) : Parcelable {
    constructor(dto: LibraryDTO.Category) : this(
        title = dto.name!!,
    )
}