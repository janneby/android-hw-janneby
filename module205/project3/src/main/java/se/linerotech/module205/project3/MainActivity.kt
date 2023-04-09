package se.linerotech.module205.project3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module205.project3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use view binding and data binding to inflate the layout and set up the view model
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the search button to fetch news articles
        binding.searchButton.setOnClickListener {
            val tesla = binding.searchEditText.text.toString()
            showArticleList(tesla)
        }
    }

    // Show the list of articles
    private fun showArticleList(topic: String?) {
        if (topic.isNullOrEmpty()) {
            Toast.makeText(this, getString(R.string.no_articles_found), Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, ArticleListActivity::class.java)
            intent.putExtra(ArticleListActivity.EXTRA_SEARCH_QUERY, topic)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Hide the progress bar when returning to the main activity
        binding.progressBar.visibility = View.GONE
    }
}
