package se.linerotech.module203.guide.hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.FragmentHotelsBinding

class HotelsFragment : Fragment() {
    private var _binding: FragmentHotelsBinding? = null
    private val binding get() = _binding!!
    private val hotelsViewModel: HotelsViewModel by viewModels {
        HotelsViewModel.factory(activity?.resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHotelsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            hotelsViewModel.state.collect { state ->
                when (state) {
                    HotelsState.Loading -> showProgressBar()
                    is HotelsState.Success -> showCars(state.hotels)
                    HotelsState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showCars(tours: List<Hotel>) {
        binding.progressbar.visibility = View.GONE

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = HotelRecyclerViewAdapter(items = tours, onCellClicked = ::showHotelDetail)
            layoutManager = LinearLayoutManager(this@HotelsFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showHotelDetail(hotel: Hotel) {
        val action = HotelsFragmentDirections.hotelDetailsAction(hotel = hotel)
        findNavController().navigate(action)
    }

    private fun showError() {
        binding.apply {
            progressbar.visibility = View.GONE
            recyclerView.visibility = View.GONE
            error.root.visibility = View.VISIBLE
            error.image.setImageResource(R.drawable.hotels_error)
        }
    }
}
