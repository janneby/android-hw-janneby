package se.linerotech.module202.project2.user

sealed class UserRepositoryState {
    data object Loading : UserRepositoryState()
    data class Success(val repositories: List<UserRepository>) : UserRepositoryState()
    object Failure : UserRepositoryState()
}
