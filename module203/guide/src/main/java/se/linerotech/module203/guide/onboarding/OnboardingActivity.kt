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

        val adapter = OnboardingViewPagerAdapter(activity = this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
        }.attach()

        binding.toolbar.inflateMenu(R.menu.onboarding_menu)

        binding.toolbar.setOnMenuItemClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            true
        }
    }
}
