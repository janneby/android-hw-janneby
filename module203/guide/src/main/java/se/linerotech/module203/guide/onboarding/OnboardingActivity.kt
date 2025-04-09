package se.linerotech.module203.guide.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.ActivityOnboardingBinding
import se.linerotech.module203.guide.home.HomeActivity

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    private val onboardingViewModel: OnboardingViewModel by viewModels {
        OnboardingViewModel.factory(onGetStartedClicked = ::openHomeScreen)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeState()
        configureMenuItemClickListener()
    }

    private fun showOnboardingScreens(states: List<OnboardingState>) {
        val adapter = OnboardingViewPagerAdapter(states = states, activity = this)
        binding.viewPager.adapter = adapter
        binding.toolbar.inflateMenu(R.menu.onboarding_menu)
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

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle((Lifecycle.State.CREATED)) {
                onboardingViewModel.state.collect { states ->
                    showOnboardingScreens(states)
                    showPageIndicator()
                }
            }
        }
    }

    private fun openHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
