package se.linerotech.module203.project1.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.project1.R

class OnboardingViewModel(private val onGetStartedClicked: () -> Unit) : ViewModel() {
    private val _state = MutableStateFlow(onboardingStates())
    val state: StateFlow<List<OnboardingState>> = _state

    private fun onboardingStates(): List<OnboardingState> {
        return listOf(
            OnboardingState(
                title = R.string.discover,
                subtitle = R.string.thousands_of_books_at_your_fingertip,
                image = R.drawable.onboarding_1,
                showGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                title = R.string.share,
                subtitle = R.string.send_to_your_friends_your_favorite_reads,
                image = R.drawable.onboarding_2,
                showGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                title = R.string.collect,
                subtitle = R.string.never_miss_a_page_create_collections_and_save_your_favorite_books,
                image = R.drawable.onboarding_3,
                showGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                title = R.string.personalize,
                subtitle = R.string.set_your_own_tone_look_and_feel_make_it_yours,
                image = R.drawable.onboarding_4,
                showGetStarted = true,
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
