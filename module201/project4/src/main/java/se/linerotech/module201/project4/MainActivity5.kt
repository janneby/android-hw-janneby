package se.linerotech.module201.project4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.project4.databinding.ActivityMain5Binding
import java.util.Locale
import kotlin.math.pow

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonOnClickListener()
    }

    private fun setButtonOnClickListener() {
        binding.buttonCalculateMortage.setOnClickListener() {
            calculateMortage()
        }
    }

    private fun calculateMortage() {
//        Valid comment to explain the loan calculation that is used in this scenario
//        ==============================================================================
//        How to calculate the monthly payments of a mortgage:
//        M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
//        ==============================================================================
//        M = Total monthly payment
//        P = The total amount of your loan
//        I = Your interest rate, as a monthly percentage
//        N = The total amount of months in your timeline for paying off your mortgage

        val loanAmountP = binding.editTextLoanAmount.text.toString().toDouble()
        val interestRateI = binding.editTextInterestRate.text.toString().toDouble()
        val payBacktimeN = binding.editTextPaybackTime.text.toString().toDouble()

        val p = loanAmountP
        val i = interestRateI / GETTING_PERCENT_VALUE / MONTHS_IN_A_YEAR
        val n = payBacktimeN * MONTHS_IN_A_YEAR

        // M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
        val mortage = p * (i * (DOUBLE_ONE_ZERO + i).pow(n)) / ((DOUBLE_ONE_ZERO + i).pow(n) - DOUBLE_ONE_ZERO)

        binding.setTextKrMonth.text = getString(
            R.string.mortage_value,
            String.format(Locale.forLanguageTag("sv_SE"), "%.0f", mortage)
        )
    }

    companion object {
        private const val GETTING_PERCENT_VALUE = 100.0
        private const val MONTHS_IN_A_YEAR = 12.0
        private const val DOUBLE_ONE_ZERO = 1.0
    }
}
