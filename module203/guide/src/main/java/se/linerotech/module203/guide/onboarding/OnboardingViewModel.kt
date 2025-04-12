package se.linerotech.module203.guide.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.guide.R

class OnboardingViewModel(private val onGetStartedClicked: () -> Unit) : ViewModel() {
    private val _state = MutableStateFlow(onboardingStates())
    val state: StateFlow<List<OnboardingState>> = _state

    private fun onboardingStates(): List<OnboardingState> {
        return listOf(
            OnboardingState(
                title = R.string.transportation,
                subtitle = R.string.rent_a_car_from_an_extensive_variety_of_types_and_models,
                image = R.drawable.onboarding_1,
                showGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                title = R.string.flights,
                subtitle = R.string.cheap_flights_to_anywhere_in_the_world_you_can_imagine,
                image = R.drawable.onboarding_2,
                showGetStarted = false,
                onGetStartedClicked = {},
            ),
            OnboardingState(
                title = R.string.tours,
                subtitle = R.string.the_best_attractions_for_you_and_your_family,
                image = R.drawable.onboarding_3,
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
