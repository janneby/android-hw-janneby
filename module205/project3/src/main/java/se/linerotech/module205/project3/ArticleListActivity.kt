package se.linerotech.module205.project3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module205.project3.backend.NewsApiClient
import se.linerotech.module205.project3.databinding.ActivityArticleListBinding
import se.linerotech.module205.project3.model.Article
import se.linerotech.module205.project3.model.NewsData
import java.util.*

class ArticleListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleListBinding
    private lateinit var adapter: ArticleAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var currentLanguage = "en" // Store the current language

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArticleListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the search query from the intent extras
        val query = intent?.getStringExtra(EXTRA_SEARCH_QUERY)

        // Make a network request to retrieve the articles
        fetchNews(query)
    }

    // Inflate the option menu in the toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Handle click events on menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_language_english -> {
                // Handle changing the language to English
                setLocale("en")
                true
            }
            R.id.menu_language_swedish -> {
                // Handle changing the language to Swedish
                setLocale("sv")
                true
            }
            R.id.menu_language_spanish -> {
                // Handle changing the language to Spanish
                setLocale("es")
                true
            }
            R.id.menu_language_arabic -> {
                // Handle changing the language to Arabic
                setLocale("ar")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setLocale(languageCode: String) {
        currentLanguage = languageCode
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
        recreate()
    }

    private fun showArticleList(listOfArticle: List<Article>) {
        // Set the visibility of the progress bar to GONE
        binding.progressBar.visibility = View.GONE
        val recyclerView: RecyclerView = binding.recyclerView
        adapter = ArticleAdapter(listOfArticle) {
            val intent = Intent(this, ArticleDetailsActivity::class.java)
            intent.putExtra(ArticleDetailsActivity.EXTRA_ARTICLE, it)
            startActivity(intent)
        }
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun fetchNews(query: String?) {
        if (query == null) {
            Toast.makeText(this, "Search query is null", Toast.LENGTH_SHORT).show()
            return
        }

        val apiKey = "<<YOUR OWN API KEY GOES HERE>>"
        val language = getCurrentLanguage() // Use the current language

        NewsApiClient.newsApiService.searchNews(query, language, apiKey)
            .enqueue(object : Callback<NewsData> {
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    if (response.isSuccessful) {
                        val newsData = response.body()?.articles ?: emptyList()
                        showArticleList(newsData)
                    } else {
                        Toast.makeText(
                            this@ArticleListActivity,
                            "Error: ${response.code()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    Toast.makeText(
                        this@ArticleListActivity,
                        "Error: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    private fun getCurrentLanguage(): String {
        // Retrieve the current locale and get the language code
        val locale = Locale.getDefault()
        return locale.language
    }

    companion object {
        const val EXTRA_SEARCH_QUERY = "extra_search_query"
    }
}
