package se.linerotech.module202.lecture

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module202.lecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModel.factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        configureToolbar()
        observerState()
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Countries"
    }

    private fun observerState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        CountryListState.Failure -> {
                            sendMessage(message = R.string.unable_to_retrieve_data)
                        }
                        CountryListState.Loading -> {
                            showProgressbar()
                        }
                        is CountryListState.Success -> {
                            showCountries(state.country)
                        }
                    }
                }
            }
        }
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(
            this@MainActivity,
            getString(message),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showProgressbar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showCountries(countries: List<Country>) {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = CountryRecyclerViewAdapter(
                countries = countries,
                onCountryClickListener = {
                    val intent = CountryDetailsActivity.intent(this@MainActivity, it)
                    startActivity(intent)
                },
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
}
