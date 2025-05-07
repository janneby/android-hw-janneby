package se.linerotech.module203.project1.discover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.databinding.FragmentDiscoverBinding

class DiscoverFragment : Fragment() {
        private var _binding: FragmentDiscoverBinding? = null
        private val binding get() = _binding!!
        private val discoverViewModel: DiscoverViewModel by viewModels {
            DiscoverViewModel.factory(activity?.resources)
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentDiscoverBinding.inflate(layoutInflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                discoverViewModel.state.collect { state ->
                    when (state) {
                        DiscoverState.Loading -> showProgressBar()
                        is DiscoverState.Success -> showDiscover(state.discover)
                        DiscoverState.Failure -> showError()
                    }
                }
            }
        }

        private fun showProgressBar() {
            binding.progressbar.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        }

        private fun showDiscover(discover: List<Discover>) {
            binding.progressbar.visibility = View.GONE

            binding.recyclerView.apply {
                visibility = View.VISIBLE
                adapter = DiscoverRecyclerViewAdapter(items = discover, onCellClicked = ::showDiscoverDetail)
                layoutManager = LinearLayoutManager(this@DiscoverFragment.context)
                setHasFixedSize(true)
            }
        }

        private fun showDiscoverDetail(discover: Discover) {
            val action = DiscoverFragmentDirections.discoverDetailsAction(discover = discover)
            findNavController().navigate(action)
        }

        private fun showError() {
            binding.apply {
                progressbar.visibility = View.GONE
                recyclerView.visibility = View.GONE
                error.root.visibility = View.VISIBLE
                error.image.setImageResource(R.drawable.cat_01)
            }
        }
    }