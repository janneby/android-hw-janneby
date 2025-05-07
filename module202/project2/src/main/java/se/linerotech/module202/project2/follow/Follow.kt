package se.linerotech.module202.project2.follow

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module202.project2.api.FollowResultDtoItem

@Parcelize
data class Follow(
    val login: String,
    val avatarUrl: String,
) : Parcelable {

    constructor(dto: FollowResultDtoItem) : this(
        login = dto.login ?: "",
        avatarUrl = dto.avatarUrl ?: "",
    )
}
