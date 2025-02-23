package se.linerotech.module201.project4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.project4.databinding.ActivityMain5Binding
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
//        Actual valid comment to explain this loan calculation
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

        val P = loanAmountP
        val i = interestRateI / 100.0 / 12.0
        val n = payBacktimeN * 12

        // M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
        val mortage = P * ( i * (1.0 + i ).pow(n) ) / ( (1.0 + i).pow(n) - 1.0 )

        binding.setTextKrMonth.text = getString(
            R.string.mortage_value,
            String.format("%.0f", mortage)
        )
    }
}

