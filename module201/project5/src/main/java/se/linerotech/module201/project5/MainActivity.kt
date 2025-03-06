package se.linerotech.module201.project5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.project5.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.Period

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val ZERO_VALUE = 0.0
        private const val AVERAGE_DAYS_IN_A_YEAR = 365.25
        private const val AVERAGE_DAYS_IN_A_MONTH = 30.4375
        private const val AVERAGE_DAYS_IN_A_WEEK = 7
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialValues()
        setTextChangedListeners()
    }

    private fun setInitialValues() {
        val initialText = getString(R.string._none)
        binding.textViewYearsOutput.text = initialText
        binding.textViewMonthsOutput.text = initialText
        binding.textViewWeeksOutput.text = initialText
        binding.textViewDaysOutput.text = initialText
    }

    private fun setTextChangedListeners() {
        binding.editTextYearOfBirth.addTextChangedListener {
            calculateAgeSummary()
        }

        binding.editTextMonthOfBirth.addTextChangedListener {
            calculateAgeSummary()
        }

        binding.editTextDayOfBirth.addTextChangedListener {
            calculateAgeSummary()
        }
    }

    private fun calculateAgeSummary() {
        val (yearInput, monthInput, dayInput) = getInputs()

        if (yearInput.isNotEmpty() && monthInput.isNotEmpty() && dayInput.isNotEmpty()) {
            if (
                yearInput.toInt() > ZERO_VALUE &&
                monthInput.toInt() > ZERO_VALUE &&
                dayInput.toInt() > ZERO_VALUE
            ) {
                val currentDate = LocalDate.now()
                val birthDate = LocalDate.of(yearInput.toInt(), monthInput.toInt(), dayInput.toInt())

                val period: Period = Period.between(birthDate, currentDate)

                val yearsLived = period.years
                val monthsLived = period.toTotalMonths().toInt()
                val daysLived = (
                    (period.years * AVERAGE_DAYS_IN_A_YEAR) +
                        (period.months * AVERAGE_DAYS_IN_A_MONTH) +
                        period.days
                    ).toInt()
                val weeksLived = daysLived / AVERAGE_DAYS_IN_A_WEEK

                setCalculatedValues(yearsLived, monthsLived, weeksLived, daysLived)
            } else {
                setInitialValues()
            }
        }
    }

    private fun getInputs(): Triple<String, String, String> {
        val yearInput = binding.editTextYearOfBirth.text.toString()
        val monthInput = binding.editTextMonthOfBirth.text.toString()
        val dayInput = binding.editTextDayOfBirth.text.toString()
        return Triple(yearInput, monthInput, dayInput)
    }

    private fun setCalculatedValues(
        yearsLived: Int,
        monthsLived: Int,
        weeksLived: Int,
        daysLived: Int,
    ) {
        binding.textViewYearsOutput.text = "$yearsLived"
        binding.textViewMonthsOutput.text = "$monthsLived"
        binding.textViewWeeksOutput.text = "$weeksLived"
        binding.textViewDaysOutput.text = "$daysLived"
    }
}
