package se.linerotech.module203.project2.incidents

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
import se.linerotech.module203.project2.databinding.FragmentIncidentsBinding

class IncidentsFragment : Fragment() {
    private var _binding: FragmentIncidentsBinding? = null
    private val binding get() = _binding!!
    private val incidentsViewModel: IncidentsViewModel by viewModels {
        IncidentsViewModel.factory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIncidentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            incidentsViewModel.state.collect { state ->
                when (state) {
                    IncidentsState.Loading -> showProgressBar()
                    is IncidentsState.Success -> showIncidents(state.incidents)
                    IncidentsState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showIncidents(incidents: List<Incident>) {
        binding.progressbar.visibility = View.GONE
        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = IncidentsRecyclerViewAdapter(
                items = incidents,
                onCellClicked = { incident -> showIncidentDetail(incident.url.orEmpty()) }
            )
            layoutManager = LinearLayoutManager(this@IncidentsFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showIncidentDetail(url: String) {
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
