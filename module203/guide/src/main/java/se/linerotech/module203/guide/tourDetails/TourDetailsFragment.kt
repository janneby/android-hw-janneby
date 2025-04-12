package se.linerotech.module203.guide.tourDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.FragmentTourDetailsBinding

class TourDetailsFragment : Fragment() {
    private var _binding: FragmentTourDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: TourDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTourDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tour = args.tour

        binding.title.text = tour.name
        //binding.cost.text = tour.cost.toString()
        binding.cost.text = getString(R.string.sek, tour.cost)
        //binding.days.text = tour.days.toString()
        binding.days.text = resources.getQuantityString(R.plurals.days, tour.days, tour.days)
        binding.location.text = tour.location
        binding.description.text = tour.description
        loadImage(tour.image)

        //Log.i("TourDetail", tour.toString())
    }

    private fun loadImage(url: String) {
        Glide
            .with(binding.image)
            .load(url)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(25)))
            .into(binding.image)
    }
}
