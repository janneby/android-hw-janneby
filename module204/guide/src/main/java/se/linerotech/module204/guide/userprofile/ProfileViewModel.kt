package se.linerotech.module204.guide.userprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.repository.datastore.UserDetails
import se.linerotech.module204.guide.repository.datastore.UserDetailsRepository

class ProfileViewModel(private val userDetailsRepository: UserDetailsRepository) : ViewModel() {
    private val _state = MutableStateFlow<ProfileState>(ProfileState.Idle)
    val state: StateFlow<ProfileState> = _state

    fun save(userDetails: UserDetails) {
        viewModelScope.launch {
            if (!userDetails.isValid()) {
                _state.value = ProfileState.InvalidUserDetails(
                    isNameValid = userDetails.isNameValid(),
                    isEmailValid = userDetails.isEmailValid(),
                    isUsernameValid = userDetails.isUsernameValid(),
                )
            } else {
                val isSavingSuccessful = userDetailsRepository.put(userDetails)
                _state.value = if (isSavingSuccessful) ProfileState.SuccessSaving else ProfileState.ErrorSaving
            }
        }
    }

    companion object {
        fun factory(userDetailsRepository: UserDetailsRepository): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ProfileViewModel(userDetailsRepository) as T
                }
            }
        }
    }
}
