package se.linerotech.module201.project5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.project5.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val ZERO_VALUE = 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTextChangedListeners()
    }

    private fun setTextChangedListeners() {
        var year: Int = 1
        var month: Int = 1
        var day: Int = 1
        binding.editTextYearOfBirth.addTextChangedListener {
            year = readYearInput()
            calculateAgeSummary(year = year, month = month, day = day)
        }

        binding.editTextMonthOfBirth.addTextChangedListener {
            month = readMonthInput()
            calculateAgeSummary(year = year, month = month, day = day)
        }

        binding.editTextDayOfBirth.addTextChangedListener {
            month = readDayInput()
            calculateAgeSummary(year = year, month = month, day = day)
        }
    }

    private fun readYearInput(): Int {
        val year: Int = binding.editTextYearOfBirth.text.toString().toInt()
        if (year >= 0 && year < 2025) {
            return year
        } else {
            Toast.makeText(
                this,
                getString(R.string.year_is_asumed_to_have_max_4_digits_max_birth_is_2025),
                Toast.LENGTH_SHORT
            ).show()
            binding.editTextYearOfBirth.setText("${year / 10}")
            return year / 10
        }
    }

    private fun readMonthInput(): Int {
        val month: Int = binding.editTextMonthOfBirth.text.toString().toInt()
        if (month >= 0 && month <= 12) {
            return month
        } else {
            Toast.makeText(
                this,
                getString(R.string.month_is_asumed_to_have_max_2_digits_max_month_is_12),
                Toast.LENGTH_SHORT
            ).show()
            binding.editTextMonthOfBirth.setText("${month / 10}")
            return month / 10
        }
    }

    private fun readDayInput(): Int {
        val day: Int = binding.editTextDayOfBirth.text.toString().toInt()
        if (day >= 0 && day <= 31) {
            return day
        } else {
            Toast.makeText(
                this,
                getString(R.string.day_is_asumed_to_have_max_2_digits_max_day_is_31),
                Toast.LENGTH_SHORT
            ).show()
            binding.editTextMonthOfBirth.setText("${day / 10}")
            return day / 10
        }
    }

    private fun calculateAgeSummary(year: Int, month: Int, day: Int) {
        val currentDate = Calendar.getInstance()
        val birthDate = Calendar.getInstance()
        birthDate.set(year, month, day)

        val milliSecLived = currentDate.timeInMillis - birthDate.timeInMillis

        val daysLived = milliSecLived / (1000 * 60 * 60 * 24)
        val weeksLived = milliSecLived / (1000 * 60 * 60 * 24) / 7.0
        val monthsLived = milliSecLived / (1000 * 60 * 60 * 24) / 12.0
        val yearsLived = milliSecLived / (1000 * 60 * 60 * 24) / 365.0

        binding.textViewYearsOutput.setText(String.format("%.2f", yearsLived))
        binding.textViewMonthsOutput.setText(String.format("%.2f", monthsLived))
        binding.textViewWeeksOutput.setText(String.format("%.2f", weeksLived))
        binding.textViewDaysOutput.setText(daysLived.toString())
    }
}
