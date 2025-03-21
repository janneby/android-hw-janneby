package se.linerotech.module202.project1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
                    Toast.makeText(this@CityWeatherActivity, "We got a problem!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CityWeatherDTO>, t: Throwable) {
                Toast.makeText(this@CityWeatherActivity, "Failed to retrieve weatherdata!", Toast.LENGTH_SHORT).show()
            }
        })
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
        return intent.getParcelableExtra(KEY_CITY)!!
    }

    private fun showCityWeather(city: String, cityWeather: CityWeatherDTO.Current?) {
        binding.textViewCityName.text = city
        binding.textViewTemp.text = cityWeather?.tempC.toString()
        binding.textViewWeatherCondition.text = cityWeather?.condition?.text.toString()
        binding.textViewCloudiness.text = cityWeather?.cloud.toString()
        binding.textViewHumidity.text = cityWeather?.humidity.toString()
        binding.textViewUvIndex.text = cityWeather?.uv.toString()
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
