package se.linerotech.module203.project1.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingViewPagerAdapter(
    private val states: List<OnboardingState>,
    activity: FragmentActivity,
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return states.size
    }

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment.instance(state = states[position])
    }
}
