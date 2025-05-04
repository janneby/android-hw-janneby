package se.linerotech.module203.guide.hotels

import android.os.Bundle
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
import se.linerotech.module203.guide.databinding.FragmentHotelDetailsBinding

class HotelDetailsFragment : Fragment() {
    private var _binding: FragmentHotelDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: HotelDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHotelDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hotel = args.hotel

        binding.title.text = hotel.name
        binding.stars.text = resources.getQuantityString(R.plurals.seats, hotel.stars, hotel.stars)
        binding.reviews.text = resources.getQuantityString(R.plurals.reviews, hotel.reviews, hotel.reviews)
        binding.cost.text = getString(R.string.sek_night, hotel.pricePerNight)
        binding.description.text = hotel.details
        loadImage(hotel.image)
    }

    private fun loadImage(url: String) {
        Glide
            .with(binding.image)
            .load(url)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(ROUNDING_RADIUS)))
            .into(binding.image)
    }

    companion object {
        private const val ROUNDING_RADIUS = 25
    }
}
