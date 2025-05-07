package se.linerotech.module203.project1.profile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Library(
    val name: String,

    ) : Parcelable {
    constructor(dto: ProfileDTO) : this(
        name = dto.name!!,
    )
}