package se.linerotech.module202.guide.newsDetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import se.linerotech.module202.guide.R
import se.linerotech.module202.guide.common.News
import se.linerotech.module202.guide.databinding.ActivityNewsDetailsBinding

class NewsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        showDetails(news = news())
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun configureToolbar() {
        setSupportActionBar((binding.toolbar))
        supportActionBar?.apply {
            this.title = ""
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.arrow_back)
        }
    }

    private fun news(): News {
        return intent.getParcelableExtra<News>(KEY_NEWS)!!
    }

    private fun showDetails(news: News) {
        binding.textViewSource.text = news.title
        binding.textViewDate.text = news.date
        binding.textViewDescription.text = news.description
        binding.buttonReadStory.setOnClickListener {
            openBrowser(url = news.url)
        }
        loadImage(url = news.image)
    }

    private fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun loadImage(url: String) {
        if (url.isEmpty()) {
            binding.image.setImageResource(R.drawable.general_image)
        } else {
            Glide
                .with(binding.image)
                .load(url)
                .placeholder(R.drawable.general_image)
                .centerCrop()
                .into(binding.image)
        }
    }

    companion object {
        private const val KEY_NEWS = "KEY_NEWS"

        fun intent(context: Context, news: News): Intent {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(KEY_NEWS, news)
            return intent
        }
    }
}
