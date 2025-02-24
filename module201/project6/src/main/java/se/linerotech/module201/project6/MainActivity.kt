package se.linerotech.module201.project6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.project6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialValues()
        setTextChangeListeners()
    }

    private fun setInitialValues() {
        val initialText = getString(R.string._none)
        binding.textViewBmiScore.text = initialText
        binding.textViewBmiLevel.text = initialText
    }

    private fun setTextChangeListeners() {
        binding.editTextYourWeight.addTextChangedListener {
            calculateBmi()
        }

        binding.editTextYourHeight.addTextChangedListener {
            calculateBmi()
        }
    }

    private fun calculateBmi() {
        val weightInput = binding.editTextYourWeight.text.toString()
        val heightInput = binding.editTextYourHeight.text.toString()

        if (weightInput.isNotEmpty() && heightInput.isNotEmpty()) {
            var canConvert = true

            val weightInKg = weightInput.toDouble()
            val heightInCm = heightInput.toDouble()

            if (!isInputValid(input = weightInKg)) {
                notifyInvalidWeight()
                canConvert = false
            }

            if (!isInputValid(input = heightInCm)) {
                notifyInvalidHeight()
                canConvert = false
            }

            if (canConvert) {
                val bmiScore = calculateBmiScore(weight = weightInKg, height = heightInCm)
                showBmiResults(bmiScore)
            }
        } else {
            setInitialValues()
        }
    }

    private fun calculateBmiScore(weight: Double, height: Double): Double {
        val heightInMeter = height / 100.0
        return weight / (heightInMeter * heightInMeter)
    }

    @SuppressLint("DefaultLocale")
    private fun showBmiResults(bmiScore: Double) {
        val bmiLevel = getBmiLevel(bmiScore)

        binding.textViewBmiScore.text = String.format("%.2f", bmiScore)
        binding.textViewBmiLevel.text = getString(bmiLevel.text)
    }

    private fun isInputValid(input: Double): Boolean {
        return input != 0.0
    }

    private fun notifyInvalidWeight() {
        binding.editTextYourWeight.error = getString(R.string.invalid_weight_value)
    }

    private fun notifyInvalidHeight() {
        binding.editTextYourHeight.error = getString(R.string.invalid_height_value)
    }

    fun getBmiLevel(bmiScore: Double): BmiLevel {
        return when {
            bmiScore < 18.5 -> BmiLevel.Underweight
            bmiScore in 18.5..24.99 -> BmiLevel.Normal
            bmiScore in 25.0..29.99 -> BmiLevel.Overweight
            bmiScore in 30.0..39.99 -> BmiLevel.Obese
            else -> BmiLevel.ServerlyObese
        }
    }
}

enum class BmiLevel(@StringRes val text: Int) {
    Underweight(text = R.string.underweight),
    Normal(text = R.string.normal),
    Overweight(text = R.string.overweight),
    Obese(text = R.string.obese),
    ServerlyObese(text = R.string.severely_obese)
}
