package se.linerotech.module203.guide.tourDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import se.linerotech.module203.guide.R

class TourDetailsFragment : Fragment() {
    private val args: TourDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tour_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tour = args.tour
        Log.i("TourDetail", tour.toString())
    }
}
