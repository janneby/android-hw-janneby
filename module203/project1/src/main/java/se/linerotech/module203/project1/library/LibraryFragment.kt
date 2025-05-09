package se.linerotech.module203.project1.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment() {
    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!
    private val libraryViewModel: LibraryViewModel by viewModels {
        LibraryViewModel.factory(activity?.resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLibraryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            libraryViewModel.state.collect { state ->
                when (state) {
                    LibraryState.Loading -> showProgressBar()
                    is LibraryState.Success -> showLibrary(state.library)
                    LibraryState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun showLibrary(library: List<Library>) {
        binding.progressbar.visibility = View.GONE

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = LibraryRecyclerViewAdapter(items = library, onCellClicked = ::showLibraryDetails)
            layoutManager = LinearLayoutManager(this@LibraryFragment.context)
            setHasFixedSize(true)
        }
    }

    private fun showLibraryDetails(library: Library) {
        val action = LibraryFragmentDirections.libraryDetailsAction(library = library)
        findNavController().navigate(action)
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
