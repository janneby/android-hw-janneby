package se.linerotech.module202.project2.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import se.linerotech.module202.project2.api.UserRepositoryDto

@Parcelize
data class UserRepository(
    val login: String,
) : Parcelable {

    constructor(dto: UserRepositoryDto.UserRepositoryDtoItem) : this(
        login = dto.fullName ?: "",
    )
}
