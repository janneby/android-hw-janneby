package se.linerotech.module202.lecture

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import se.linerotech.module202.lecture.databinding.ActivityCountryDetailsBinding

class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        showCountryDetails(country = country())
    }

    private fun configureToolbar() {
        setSupportActionBar((binding.toolbar))
        supportActionBar?.apply {
            this.title = ""
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.arrow_back)
        }
    }

    private fun country(): Country {
        return intent.getParcelableExtra<Country>(KEY_COUNTRY)!!
    }

    private fun showCountryDetails(country: Country) {
        loadFlag(url = country.flagUrl)
        binding.textViewCountryName.text = country.countryName
        binding.textViewWorldRegion.text = country.worldRegion
        binding.textViewPopulation.text = country.population
        binding.textViewArea.text = country.area
        binding.textViewCapital.text = country.capital
        binding.textViewCallingCode.text = country.callingCode
        binding.textViewTopLevelDomain.text = country.topLevelDomain
    }

    private fun loadFlag(url: String) {
        if (url.isEmpty()) {
            binding.imageViewFlag.setImageResource(R.drawable.world)
        } else {
            Glide
                .with(binding.imageViewFlag)
                .load(url)
                .placeholder(R.drawable.world)
                .centerCrop()
                .into(binding.imageViewFlag)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val KEY_COUNTRY = "KEY_COUNTRY"

        fun intent(context: Context, country: Country): Intent {
            val intent = Intent(context, CountryDetailsActivity::class.java)
            intent.putExtra(KEY_COUNTRY, country)
            return intent
        }
    }
}
