package se.linerotech.module202.project1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module202.project1.databinding.ActivityMainBinding

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
        supportActionBar?.title = "Select a City"
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle((Lifecycle.State.CREATED)) {
                viewModel.state.collect(::showCities)
            }
        }
    }
    private fun showCities(cities: List<City>) {
        binding.recyclerView.apply {
            adapter = CityRecyclerViewAdapter(items = cities, onCellClicked = ::showCity)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
        }
    }

    private fun showCity(city: City) {
        val intent = CityWeatherActivity.intent(this, city)
        startActivity(intent)
    }
}
