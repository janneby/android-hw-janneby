package se.linerotech.module203.guide.flights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.FragmentFlightsBinding

class FlightsFragment : Fragment() {
    private var _binding: FragmentFlightsBinding? = null
    private val binding get() = _binding!!
    private val flightsViewModel: FlightsViewModel by viewModels {
        FlightsViewModel.factory(activity?.resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFlightsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            flightsViewModel.state.collect { state ->
                when (state) {
                    FlightsState.Loading -> showProgressBar()
                    is FlightsState.Success -> showFlights(state.flights)
                    FlightsState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showFlights(flights: List<Flight>) {
        binding.progressbar.visibility = View.GONE

        binding.recyclerView.apply {
            visibility = View.VISIBLE

            adapter = FlightRecyclerViewAdapter(items = flights, onCellClicked = ::showFlightDetail)
            layoutManager = LinearLayoutManager(this@FlightsFragment.context)
            setHasFixedSize(true)
        }
    }

    fun showFlightDetail(flight: Flight) {
        Toast.makeText(context, "Flight Details: ${flight.from} - ${flight.to}", Toast.LENGTH_LONG).show()
    }

    private fun showError() {
        binding.apply {
            progressbar.visibility = View.GONE
            recyclerView.visibility = View.GONE
            error.root.visibility = View.VISIBLE
            error.image.setImageResource(R.drawable.flights_error)
        }
    }
}
