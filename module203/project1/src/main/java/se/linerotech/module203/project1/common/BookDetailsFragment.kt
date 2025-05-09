package se.linerotech.module203.project1.common

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import jp.wasabeef.glide.transformations.BlurTransformation
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.databinding.FragmentBookDetailsBinding

class BookDetailsFragment : Fragment() {
    private var _binding: FragmentBookDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: BookDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        showBookDetails()
    }

    private fun showBookDetails() {
        val book = args.book

        binding.textViewBookTitle.text = book.title
        binding.textViewBookAuthor.text = book.author
        binding.textViewAverageRating.text = book.averageRating.toString()
        binding.textViewRatingCount.text = getString(R.string.raters, book.ratingCount)
        binding.textViewPages.text = getString(R.string.pages, book.pageCount)
        binding.textViewYear.text = book.publicationDate
        binding.textViewISBN.text = book.isbn
        binding.textViewDescription.text = book.description

        binding.buttonContinueReading.setOnClickListener {
            openBrowser(
                url = getString(
                    R.string.https_www_google_se_search_q
                ) + book.title + getString(
                    R.string.space
                ) + book.author
            )
        }

        loadImage(book.image)
        loadBlurred(book.image)
    }

    private fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadImage(url: String) {
        Glide
            .with(binding.imageViewBook)
            .load(url)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(ROUNDING_RADIUS)))
            .into(binding.imageViewBook)
    }

    private fun loadBlurred(url: String) {
        Glide
            .with(binding.imageViewBlurredBook)
            .load(url)
            .apply(bitmapTransform(BlurTransformation(BLUR_RADIUS, SAMPLING_VALUE)))
            .apply(RequestOptions().transform(CenterCrop()))
            .into(binding.imageViewBlurredBook)
    }

    companion object {
        private const val ROUNDING_RADIUS = 25
        private const val BLUR_RADIUS = 100
        private const val SAMPLING_VALUE = 8
    }
}
