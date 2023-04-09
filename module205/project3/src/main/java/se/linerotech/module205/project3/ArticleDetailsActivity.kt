package se.linerotech.module205.project3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import se.linerotech.module205.project3.databinding.ActivityArticleDetailsBinding
import se.linerotech.module205.project3.model.Article

class ArticleDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get article data passed from the previous activity
        val article = intent.getParcelableExtra<Article>(EXTRA_ARTICLE)
        article?.let {
            binding.titleTextView.text = it.title
            binding.authorTextView.text = it.author
            binding.descriptionTextView.text = it.description
            binding.contentTextView.text = it.content

            // Load article image using the Glide library
            Glide.with(this)
                .load(it.urlToImage)
                .into(binding.imageView)
        }
    }

    companion object {
        const val EXTRA_ARTICLE = "extra_article"
    }
}

