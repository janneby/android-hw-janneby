package se.linerotech.module202.guide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module202.guide.databinding.ActivityNewsListBinding

class NewsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsListBinding
    private val viewModel: NewsListViewModel by viewModels { NewsListViewModel.factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar(title = categoryName())
        observeState()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun configureToolbar(title: String?) {
        setSupportActionBar((binding.toolbar))
        supportActionBar?.apply {
            this.title = title
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.arrow_back)
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle((Lifecycle.State.CREATED)) {
                viewModel.state.collect { state ->
                    when (state) {
                        NewsListState.Loading -> showProgressBar()
                        is NewsListState.Success -> showNews(news = state.news)
                        NewsListState.Failure -> showErrorMessage()
                    }
                }
            }
        }
    }

    private fun categoryName(): String {
        return intent.getStringExtra(KEY_CATEGORY_NAME) ?: ""
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showErrorMessage() {
        Toast.makeText(this, getString(R.string.unable_to_retrieve_news), Toast.LENGTH_LONG).show()
    }

    private fun showNews(news: List<News>) {
        hideProgressBar()

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            addItemDecoration(DividerItemDecoration(this@NewsListActivity), LinearLayout.VERTICAL)
            adapter = NewsRecyclerViewAdapter(items = news, onCellClicked = ::showNewsDetails)
            layoutManager = LinearLayoutManager(this@NewsListActivity)
            setHasFixedSize(true)
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showNewsDetails() {
    }

    companion object {
        private const val KEY_CATEGORY_NAME = "KEY_CATEGORY_NAME"

        fun intent(context: Context, categoryName: String): Intent {
            val intent = Intent(context, NewsListActivity::class.java)
            intent.putExtra(KEY_CATEGORY_NAME, categoryName)
            return intent
        }
    }
}
