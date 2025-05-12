package se.linerotech.module204.guide.userprofile

sealed class ProfileState {
    object Idle : ProfileState()
    object ErrorSaving : ProfileState()
    object SuccessSaving : ProfileState()
    data class InvalidUserDetails(
        val isNameValid: Boolean,
        val isEmailValid: Boolean,
        val isUsernameValid: Boolean,
    ) : ProfileState()
}
