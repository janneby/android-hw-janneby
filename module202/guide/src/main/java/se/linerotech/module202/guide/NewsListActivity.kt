package se.linerotech.module202.guide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module202.guide.databinding.ActivityNewsListBinding

class NewsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar(title = categoryName())
        showNews()
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

    private fun categoryName(): String {
        return intent.getStringExtra(KEY_CATEGORY_NAME) ?: ""
    }

    private fun showNews() {
        val dividerItemDecorator = DividerItemDecoration(this, LinearLayout.VERTICAL)

        binding.recyclerView.apply {
            addItemDecoration(dividerItemDecorator)
            adapter =
                NewsRecyclerViewAdapter(items = dummyNewsData(), onCellClicked = ::showNewsDetails)
            layoutManager = LinearLayoutManager(this@NewsListActivity)
            setHasFixedSize(true)
        }
    }

    private fun dummyNewsData(): List<News> {
        // return emptyList()
        return listOf(
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
        )
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
