package se.linerotech.module203.guide.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import se.linerotech.module203.guide.HomeActivity
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showOnboardingScreens()
        showPageIndicator()
        configureMenuItemClickListener()
    }

    private fun showOnboardingScreens() {
        val adapter = OnboardingViewPagerAdapter(states = onboardingStates(), activity = this)
        binding.viewPager.adapter = adapter
        binding.toolbar.inflateMenu(R.menu.onboarding_menu)
    }

    private fun onboardingStates(): List<OnboardingState> {
        return listOf(
            OnboardingState(
                title = R.string.transportation,
                subtitle = R.string.rent_a_car_from_an_extensive_variety_of_types_and_models,
                image = R.drawable.onboarding_1,
                showGetStarted = false
            ),
            OnboardingState(
                title = R.string.flights,
                subtitle = R.string.cheap_flights_to_anywhere_in_the_world_you_can_imagine,
                image = R.drawable.onboarding_2,
                showGetStarted = false
            ),
            OnboardingState(
                title = R.string.flights,
                subtitle = R.string.the_best_attractions_for_you_and_your_family,
                image = R.drawable.onboarding_3,
                showGetStarted = true
            )
        )
    }

    private fun showPageIndicator() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
        }.attach()
    }

    private fun configureMenuItemClickListener() {
        binding.toolbar.setOnMenuItemClickListener {
            openHomeScreen()
            true
        }
    }

    private fun openHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
