package se.linerotech.module202.project1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module202.project1.api.CityWeatherDTO
import se.linerotech.module202.project1.api.Credentials
import se.linerotech.module202.project1.api.RetroFitClient
import se.linerotech.module202.project1.databinding.ActivityCityWeatherBinding

class CityWeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        retrieveCityWeather()
    }

    private fun retrieveCityWeather() {
        RetroFitClient.instance.cityWeather(
            apikey = Credentials.weatherApiKey,
            q = city().id,
        ).enqueue(object : Callback<CityWeatherDTO> {
            override fun onResponse(call: Call<CityWeatherDTO>, response: Response<CityWeatherDTO>) {
                if (response.isSuccessful && response.body() != null && response.body()!!.current != null) {
                    val currentCityWeather = response.body()!!.current
                    showCityWeather(city().id, currentCityWeather)
                } else {
                    Toast.makeText(
                        this@CityWeatherActivity,
                        getString(R.string.we_got_a_problem),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<CityWeatherDTO>, t: Throwable) {
                Toast.makeText(
                    this@CityWeatherActivity,
                    getString(R.string.failed_to_retrieve_weatherdata),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun configureToolbar() {
        // setSupportActionBar((binding.toolbar))
        supportActionBar?.apply {
            this.title = ""
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.back_arrow)
        }
    }

    private fun city(): City {
        return intent.getParcelableExtra(KEY_CITY)!!
    }

    private fun showCityWeather(city: String, cityWeather: CityWeatherDTO.Current?) {
        binding.textViewCityName.text = city.first().uppercase() + city.substring(1, city.length)
        binding.textViewTemp.text = cityWeather?.tempC.toString()
        binding.textViewWeatherCondition.text = cityWeather?.condition?.text.toString()
        binding.textViewCloudiness.text = cityWeather?.cloud.toString()
        binding.textViewHumidity.text = cityWeather?.humidity.toString()
        binding.textViewUvIndex.text = cityWeather?.uv.toString()

        if (cityWeather?.condition?.text.toString().contains(getString(R.string.sunny), ignoreCase = true)) {
            binding.root.background = getDrawable(R.drawable.background_sunny)
        }

        if (cityWeather?.condition?.text.toString().contains(getString(R.string.cloudy), ignoreCase = true)) {
            binding.root.background = getDrawable(R.drawable.background_cloudy)
        }

        if (cityWeather?.condition?.text.toString().contains(getString(R.string.rainy), ignoreCase = true)) {
            binding.root.background = getDrawable(R.drawable.background_rainy)
        }

        if (cityWeather?.condition?.text.toString().contains(getString(R.string.clear), ignoreCase = true)) {
            binding.root.background = getDrawable(R.drawable.background_night)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val KEY_CITY = "KEY_CITY"

        fun intent(context: Context, city: City): Intent {
            val intent = Intent(context, CityWeatherActivity::class.java)
            intent.putExtra(KEY_CITY, city)
            return intent
        }
    }
}
