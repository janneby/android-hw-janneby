package se.linerotech.module203.lecture.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.lecture.R

class OnboardingViewModel(private val onGetStartedClicked: () -> Unit) : ViewModel() {
    private val _state = MutableStateFlow(onboardingStates())
    val state: StateFlow<List<OnboardingState>> = _state

    private fun onboardingStates(): List<OnboardingState> {
        return listOf(
            OnboardingState(
                image = R.drawable.onboarding_1,
                title = R.string.stay_connected_with_your_colleagues_and_friends,
                showButtonGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                image = R.drawable.onboarding_2,
                title = R.string.never_miss_a_notification_everthing_easily_accessible,
                showButtonGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                image = R.drawable.onboarding_3,
                title = R.string.peace_of_mind_never_miss_an_important_notification,
                showButtonGetStarted = true,
                onGetStartedClicked = { onGetStartedClicked() }
            )
        )
    }

    companion object {
        fun factory(onGetStartedClicked: () -> Unit): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return OnboardingViewModel(onGetStartedClicked) as T
                }
            }
        }
    }
}
