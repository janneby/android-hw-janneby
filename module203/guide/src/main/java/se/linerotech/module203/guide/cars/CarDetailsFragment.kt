package se.linerotech.module203.guide.cars

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
import se.linerotech.module203.guide.databinding.FragmentCarDetailsBinding

class CarDetailsFragment : Fragment() {
    private var _binding: FragmentCarDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: CarDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val car = args.car

        binding.title.text = car.name
        binding.seats.text = resources.getQuantityString(R.plurals.seats, car.seat, car.seat)
        binding.transmission.text = car.transmission
        binding.cost.text = getString(R.string.sek_day, car.pricePerDay)
        binding.description.text = car.details
        loadImage(car.image)
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
