package se.linerotech.module201.project6

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.project6.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val CM_PER_METER = 100.0
        private const val BMI_LEVEL_UNDERWEIGHT_HIGHEST = 18.5
        private const val BMI_LEVEL_NORMAL_HIGHEST = 25.0
        private const val BMI_LEVEL_OVERWEIGHT_HIGHEST = 30.00
        private const val BMI_LEVEL_OBESE_HIGHEST = 40.00
    }

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
        val heightInMeter = height / CM_PER_METER
        return weight / (heightInMeter * heightInMeter)
    }

    private fun showBmiResults(bmiScore: Double) {
        val bmiLevel = getBmiLevel(bmiScore)

        binding.textViewBmiScore.text = String.format(
            Locale.forLanguageTag("sv_SE"),
            getString(R.string._2f),
            bmiScore
        )
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
            bmiScore < BMI_LEVEL_UNDERWEIGHT_HIGHEST -> BmiLevel.Underweight
            bmiScore in BMI_LEVEL_UNDERWEIGHT_HIGHEST..BMI_LEVEL_NORMAL_HIGHEST -> BmiLevel.Normal
            bmiScore in BMI_LEVEL_NORMAL_HIGHEST..BMI_LEVEL_OVERWEIGHT_HIGHEST -> BmiLevel.Overweight
            bmiScore in BMI_LEVEL_OVERWEIGHT_HIGHEST..BMI_LEVEL_OBESE_HIGHEST -> BmiLevel.Obese
            else -> BmiLevel.ServerelyObese
        }
    }
}

enum class BmiLevel(@StringRes val text: Int) {
    Underweight(text = R.string.underweight),
    Normal(text = R.string.normal),
    Overweight(text = R.string.overweight),
    Obese(text = R.string.obese),
    ServerelyObese(text = R.string.severely_obese)
}
