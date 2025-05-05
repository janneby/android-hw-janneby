package se.linerotech.module202.project2

import se.linerotech.module202.project2.api.UserResultDto

sealed class UserInfoState {
    data object Loading : UserInfoState()
    data class Success(val user: User) : UserInfoState()
    object Failure : UserInfoState()
}
