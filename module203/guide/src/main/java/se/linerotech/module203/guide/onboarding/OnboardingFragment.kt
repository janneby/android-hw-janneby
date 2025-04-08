package se.linerotech.module203.guide.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import se.linerotech.module203.guide.HomeActivity
import se.linerotech.module203.guide.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showOnboardingDetails()
    }

    private fun showOnboardingDetails() {
        val state = state()

        binding.title.setText(state.title)
        binding.subtitle.setText(state.subtitle)
        binding.image.setImageResource(state.image)
        binding.buttonGetStarted.visibility = if(state.showGetStarted) View.VISIBLE else View.GONE
        binding.buttonGetStarted.setOnClickListener {
            activity?.startActivity(Intent(context, HomeActivity::class.java))
            activity?.finish()
        }
    }

    private fun state(): OnboardingState {
        return arguments?.getParcelable(KEY_STATE)!!
    }

    companion object {
        private const val KEY_STATE = "keyState"

        fun instance(state: OnboardingState): OnboardingFragment {
            val bundle = Bundle()
            bundle.putParcelable(KEY_STATE, state)

            val fragment = OnboardingFragment()
            fragment.arguments = bundle

            return fragment
        }
    }
}
