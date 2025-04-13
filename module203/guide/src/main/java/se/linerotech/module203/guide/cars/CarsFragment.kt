package se.linerotech.module203.guide.cars

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
import se.linerotech.module203.guide.databinding.FragmentCarsBinding

class CarsFragment : Fragment() {
    private var _binding: FragmentCarsBinding? = null
    private val binding get() = _binding!!
    private val carsViewModel: CarsViewModel by viewModels {
        CarsViewModel.factory(activity?.resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            carsViewModel.state.collect { state ->
                when (state) {
                    CarsState.Loading -> showProgressBar()
                    is CarsState.Success -> showCars(state.cars)
                    CarsState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showCars(tours: List<Car>) {
        binding.progressbar.visibility = View.GONE

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = CarRecyclerViewAdapter(items = tours, onCellClicked = ::showCarDetail)
            layoutManager = LinearLayoutManager(this@CarsFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showCarDetail(car: Car) {
        val action = CarsFragmentDirections.carDetailsAction(car = car)
        findNavController().navigate(action)
    }

    private fun showError() {
        binding.apply {
            progressbar.visibility = View.GONE
            recyclerView.visibility = View.GONE
            error.root.visibility = View.VISIBLE
            error.image.setImageResource(R.drawable.car_error)
        }
    }
}
