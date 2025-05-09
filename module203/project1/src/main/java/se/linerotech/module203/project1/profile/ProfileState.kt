package se.linerotech.module203.project1.profile

sealed class ProfileState {
    object Loading : ProfileState()
    data class Success(val profile: Profile) : ProfileState()
    object Failure : ProfileState()
}
