package se.linerotech.module203.guide.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import se.linerotech.module203.guide.R

class OnboardingViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val state = OnboardingState(
                    title = R.string.transportation,
                    subtitle = R.string.rent_a_car_from_an_extensive_variety_of_types_and_models,
                    image = R.drawable.onboarding_1,
                    showGetStarted = false
                )

                OnboardingFragment.instance(state)
            }
            1 -> {
                val state = OnboardingState(
                    title = R.string.flights,
                    subtitle = R.string.cheap_flights_to_anywhere_in_the_world_you_can_imagine,
                    image = R.drawable.onboarding_2,
                    showGetStarted = false
                )

                OnboardingFragment.instance(state)
            }
            else -> {
                val state = OnboardingState(
                    title = R.string.flights,
                    subtitle = R.string.the_best_attractions_for_you_and_your_family,
                    image = R.drawable.onboarding_3,
                    showGetStarted = true
                )

                OnboardingFragment.instance(state)
            }
        }
    }
}
