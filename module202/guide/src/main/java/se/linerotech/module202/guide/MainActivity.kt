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
        binding.recyclerView.adapter = CategoryRecylerViewAdapter(
            items = listOf(
                Category(name = "Genereal", image = R.drawable.general_image),
                Category(name = "Business", image = R.drawable.business_image),
                Category(name = "Entertainment", image = R.drawable.entertainment_image),
                Category(name = "Health", image = R.drawable.health_image),
                Category(name = "Sports", image = R.drawable.sports_image),
                Category(name = "Science", image = R.drawable.science_image),
                Category(name = "Technology", image = R.drawable.technology_image),
            )
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Categories"
    }
}
