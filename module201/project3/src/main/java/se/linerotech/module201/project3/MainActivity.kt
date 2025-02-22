package se.linerotech.module201.project3

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.project3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TEMP_DEFAULT_VALUE = 200.0
        private const val ZERO_INT_VALUE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialTempValues()
        setTextChangedListener()
        setClickListeners()
    }

    private fun setInitialTempValues() {
        binding.buttonCelcius.performClick()
        binding.editTextTemperature.setText(TEMP_DEFAULT_VALUE.toString())
    }

    private fun setTextChangedListener() {
        binding.editTextTemperature.addTextChangedListener { text ->
            // TODO: Calcualte stuff on the fly
        }
    }

    private fun setClickListeners() {
        binding.buttonCelcius.setOnClickListener() {
            hideKeyboard()
            setTempValues(
                temp1 = celciusToFarenheit(celsius = readTemp()),
                type1 = 'f',
                temp2 = celciusToKelvin(celsius = readTemp()),
                type2 = 'k'
            )
        }

        binding.buttonFarenheit.setOnClickListener() {
            hideKeyboard()
            setTempValues(
                temp1 = farenheitToCelcius(farenheit = readTemp()),
                type1 = 'c',
                temp2 = farenheitToKelvin(farenheit = readTemp()),
                type2 = 'k'
            )
        }

        binding.buttonKelvin.setOnClickListener() {
            hideKeyboard()
            setTempValues(
                temp1 = kelvinToCelcius(kelvin = readTemp()),
                type1 = 'c',
                temp2 = kelvinToFarenheit(kelvin = readTemp()),
                type2 = 'f'
            )
        }
    }

    private fun setTempValues(temp1: Double, type1: Char, temp2: Double, type2: Char) {
        if (type1 == 'f') {
            binding.textViewOne.text = getString(
                R.string.farenheit_value,
                String.format("%.0f", temp1)
            )
        } else if (type1 == 'c') {
            binding.textViewOne.text = getString(
                R.string.celcius_value,
                String.format("%.0f", temp1)
            )
        }

        if (type2 == 'k') {
            binding.textViewTwo.text = getString(
                R.string.kelvin_value,
                String.format("%.2f", temp2)
            )
        } else if (type2 == 'f') {
            binding.textViewTwo.text = getString(
                R.string.farenheit_value,
                String.format("%.0f", temp2)
            )
        }
    }

    private fun readTemp(): Double {
        return binding.editTextTemperature.text.toString().toDouble()
    }

    private fun celciusToFarenheit(celsius: Double): Double {
        // °F = (°C × 9/5) + 32
        return (celsius * 9.0 / 5.0) + 32.0
    }

    private fun celciusToKelvin(celsius: Double): Double {
        // K = T (°C) + 273.15
        return celsius + 273.15
    }

    private fun farenheitToCelcius(farenheit: Double): Double {
        // °C = (°F − 32) x 5/9
        return (farenheit - 32.0) * 5.0 / 9.0
    }

    private fun farenheitToKelvin(farenheit: Double): Double {
        // K = (°F − 32) × 5 ⁄ 9 + 273.15
        return ((farenheit - 32.0) * 5.0 / 9.0) + 273.15
    }

    private fun kelvinToCelcius(kelvin: Double): Double {
        // °C = K - 273.15
        return kelvin - 273.15
    }

    private fun kelvinToFarenheit(kelvin: Double): Double {
        // °F = (K − 273.15) × 9/5 + 32
        return ((kelvin - 273.15) * 9.0 / 5.0) + 32
    }

    private fun hideKeyboard() {
        val activityView: View? = this.currentFocus
        if (activityView != null) {
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activityView.getWindowToken(), ZERO_INT_VALUE)
        }
    }
}
