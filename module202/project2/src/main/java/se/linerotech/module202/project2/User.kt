package se.linerotech.module202.project2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module202.project2.api.UserResultDto

@Parcelize
data class User(
    val login: String,
    val name: String,
    val location: String,
    val avatarUrl: String,
) : Parcelable {

    constructor(dto: UserResultDto) : this(
        login = dto.login ?: "",
        name = dto.name ?: "",
        location = dto.location ?: "",
        avatarUrl = dto.avatarUrl ?: "",
    )
}
