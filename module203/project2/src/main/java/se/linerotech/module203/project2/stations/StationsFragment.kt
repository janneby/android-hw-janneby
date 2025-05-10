package se.linerotech.module203.project2.stations

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module203.project2.R
import se.linerotech.module203.project2.databinding.FragmentStationsBinding

class StationsFragment : Fragment() {
    private var _binding: FragmentStationsBinding? = null
    private val binding get() = _binding!!
    private val stationsViewModel: StationsViewModel by viewModels {
        StationsViewModel.factory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStationsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            stationsViewModel.state.collect { state ->
                when (state) {
                    StationsState.Loading -> showProgressBar()
                    is StationsState.Success -> showStations(state.stations)
                    StationsState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showStations(stations: List<Station>) {
        binding.progressbar.visibility = View.GONE

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = StationsRecyclerViewAdapter(
                items = stations,
                onCellClicked = { stations -> showStationDetail(stations.url.orEmpty()) }
            )
            layoutManager = LinearLayoutManager(this@StationsFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showStationDetail(url: String) {
        val baseUrl = getString(R.string.https_polisen_se)
        val fullUrl = if (url.startsWith(getString(R.string.http))) url else "$baseUrl$url"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fullUrl))
        startActivity(intent)
    }

    private fun showError() {
        binding.apply {
            progressbar.visibility = View.GONE
            recyclerView.visibility = View.GONE
            error.root.visibility = View.VISIBLE
            error.image.setImageResource(R.drawable.error_server)
        }
    }
}
