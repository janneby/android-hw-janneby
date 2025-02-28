package se.linerotech.module202.guide.selectCategory

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module202.guide.R
import se.linerotech.module202.guide.common.Category
import se.linerotech.module202.guide.databinding.ActivityMainBinding
import se.linerotech.module202.guide.newsList.NewsListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels { MainViewModel.factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        observeState()
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.categories)
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle((Lifecycle.State.CREATED)) {
                viewModel.state.collect(::showCategories)
            }
        }
    }

    private fun showCategories(categories: List<Category>) {
        binding.recyclerView.apply {
            adapter = CategoryRecyclerViewAdapter(items = categories, onCellClicked = ::showNews)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    private fun showNews(category: Category) {
        val intent = NewsListActivity.intent(this, category.name, category.id)
        startActivity(intent)
    }
}
