package se.linerotech.module202.project2.follow

sealed class FollowState {
    object Loading : FollowState()
    data class Success(val follows: List<Follow>) : FollowState()
    object Failure : FollowState()
}
