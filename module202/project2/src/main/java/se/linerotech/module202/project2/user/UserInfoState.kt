package se.linerotech.module202.project2.user

import se.linerotech.module202.project2.common.User

sealed class UserInfoState {
    data object Loading : UserInfoState()
    data class Success(val user: User) : UserInfoState()
    object Failure : UserInfoState()
}
