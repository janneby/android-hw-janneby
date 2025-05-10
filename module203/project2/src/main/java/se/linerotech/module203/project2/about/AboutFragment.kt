package se.linerotech.module203.project2.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module203.project2.R
import se.linerotech.module203.project2.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private val aboutViewModel: AboutViewModel by viewModels {
        AboutViewModel.factory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle((Lifecycle.State.CREATED)) {
                aboutViewModel.state.collect { about -> showAbouts(about) }
            }
        }
    }

    private fun showAbouts(abouts: List<About>) {
        binding.progressbar.visibility = View.GONE
        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = AboutRecyclerViewAdapter(
                items = abouts,
                onCellClicked = { about -> showAboutDetails(about.url) }
            )
            layoutManager = LinearLayoutManager(this@AboutFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showAboutDetails(url: String) {
        val baseUrl = getString(R.string.https_polisen_se)
        val fullUrl = if (url.startsWith(getString(R.string.http))) url else "$baseUrl$url"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fullUrl))
        startActivity(intent)
    }
}
