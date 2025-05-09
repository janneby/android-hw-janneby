package se.linerotech.module203.project1.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.common.Book
import se.linerotech.module203.project1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileViewModel.factory(activity?.resources)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            profileViewModel.state.collect { state ->
                when (state) {
                    ProfileState.Loading -> showProgressBar()
                    is ProfileState.Success -> showProfile(state.profile)
                    ProfileState.Failure -> showError()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressbar.visibility = View.VISIBLE
        binding.recentlyAddedRecyclerView.visibility = View.GONE
        binding.recentlyReadRecyclerView.visibility = View.GONE
        binding.favoriteRecyclerView.visibility = View.GONE
    }

    private fun showProfile(profile: Profile) {
        binding.progressbar.visibility = View.GONE

        binding.textViewName.text = profile.profileName
        binding.textViewAmountBooks.text = profile.bookCount.toString()
        binding.textViewAmountCollections.text = profile.collections.toString()
        binding.textViewName.text = profile.profileName
        loadImage(profile.profileImage)

        binding.recentlyAddedRecyclerView.apply {
            visibility = View.VISIBLE
            adapter = BookRecyclerViewAdapter(items = profile.recentlyAddedList, onBookClicked = ::showBookDetail)
            layoutManager = LinearLayoutManager(this@ProfileFragment.context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.recentlyReadRecyclerView.apply {
            visibility = View.VISIBLE
            adapter = BookRecyclerViewAdapter(items = profile.recentlyReadList, onBookClicked = ::showBookDetail)
            layoutManager = LinearLayoutManager(this@ProfileFragment.context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.favoriteRecyclerView.apply {
            visibility = View.VISIBLE
            adapter = BookRecyclerViewAdapter(items = profile.favoriteList, onBookClicked = ::showBookDetail)
            layoutManager = LinearLayoutManager(this@ProfileFragment.context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    private fun showBookDetail(book: Book) {
        val action = ProfileFragmentDirections.profileDetailsAction(book = book)
        findNavController().navigate(action)
    }

    private fun loadImage(url: String) {
        Glide
            .with(binding.imageViewProfilePicture)
            .load(url)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(CORNER_RADIUS)))
            .into(binding.imageViewProfilePicture)
    }

    private fun showError() {
        binding.apply {
            progressbar.visibility = View.GONE
            recentlyAddedRecyclerView.visibility = View.GONE
            recentlyReadRecyclerView.visibility = View.GONE
            favoriteRecyclerView.visibility = View.GONE
            error.root.visibility = View.VISIBLE
            error.image.setImageResource(R.drawable.error_sleeping)
        }
    }

    companion object {
        const val CORNER_RADIUS = 95
    }
}
