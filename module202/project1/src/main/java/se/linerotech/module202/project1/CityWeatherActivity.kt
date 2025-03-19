package se.linerotech.module202.project1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module202.project1.databinding.ActivityCityWeatherBinding

class CityWeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        showDetails(city = city())
    }

    private fun configureToolbar() {
//        setSupportActionBar((binding.toolbar))
//        supportActionBar?.apply {
//            this.title = ""
//            setDisplayHomeAsUpEnabled(true)
//            setHomeAsUpIndicator(R.drawable.arrow_back)
//        }
    }

    private fun city(): City {
        return intent.getParcelableExtra<City>(KEY_CITY)!!
    }

    private fun showDetails(city: City) {
//        binding.textViewSource.text = news.title
//        binding.textViewDate.text = news.date
//        binding.textViewDescription.text = news.description
//        loadImage(url = news.image)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val KEY_CITY = "KEY_CITY"

        fun intent(context: Context, category: City): Intent {
            val intent = Intent(context, CityWeatherActivity::class.java)
            intent.putExtra(KEY_CITY, category)
            return intent
        }
    }
}
