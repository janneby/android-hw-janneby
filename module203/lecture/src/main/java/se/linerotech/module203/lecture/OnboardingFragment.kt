package se.linerotech.module203.lecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import se.linerotech.module203.lecture.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showOnboardingDetails(state = retrieveState())
    }

    private fun showOnboardingDetails(state: OnboardingState) {
        binding.image.setImageResource(state.image)
        binding.title.setText(state.title)
        binding.buttonGetStarted.visibility = if (state.showButtonGetStarted) View.VISIBLE else View.GONE
        binding.buttonGetStarted.setOnClickListener {
            state.onGetStartedClicked()
        }
    }

    private fun retrieveState(): OnboardingState {
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
