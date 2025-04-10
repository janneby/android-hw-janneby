package se.linerotech.module203.guide.tours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.FragmentToursBinding

class ToursFragment : Fragment() {
    private var _binding: FragmentToursBinding? = null
    private val binding get() = _binding!!
    private val toursViewModel: ToursViewModel by viewModels {
        ToursViewModel.factory(activity?.resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentToursBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            toursViewModel.state.collect { state ->
                when (state) {
                    ToursState.Loading -> showProgressBar()
                    is ToursState.Success -> showTour(state.tours)
                    ToursState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showTour(tours: List<Tour>) {
        binding.progressbar.visibility = View.GONE

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = TourRecyclerViewAdapter(items = tours, onCellClicked = {})
            layoutManager = LinearLayoutManager(this@ToursFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showError() {
        binding.apply {
            progressbar.visibility = View.GONE
            recyclerView.visibility = View.GONE
            error.root.visibility = View.VISIBLE
            error.image.setImageResource(R.drawable.tour_error)
        }
    }
}
