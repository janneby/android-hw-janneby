package se.linerotech.module202.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module202.guide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        showCategories()
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Categories"
    }

    private fun showCategories() {
        binding.recyclerView.apply {
            adapter = CategoryRecylerViewAdapter(items = categories())
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    private fun categories(): List<Category> {
        return listOf(
            Category(name = getString(R.string.general), image = R.drawable.general_image),
            Category(name = getString(R.string.business), image = R.drawable.business_image),
            Category(name = getString(R.string.entertainment), image = R.drawable.entertainment_image),
            Category(name = getString(R.string.health), image = R.drawable.health_image),
            Category(name = getString(R.string.sports), image = R.drawable.sports_image),
            Category(name = getString(R.string.science), image = R.drawable.science_image),
            Category(name = getString(R.string.technology), image = R.drawable.technology_image),
        )
    }
}
