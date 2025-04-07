package se.linerotech.module203.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module203.guide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = OnboardingViewPagerAdapter(activity = this)
        binding.viewPager.adapter = adapter
    }
}
