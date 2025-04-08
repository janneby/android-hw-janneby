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
        val adapter = OnboardingViewPagerAdapter(activity = this)
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

    private fun openHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
