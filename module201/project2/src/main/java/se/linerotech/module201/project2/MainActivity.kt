package se.linerotech.module201.project2

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.project2.databinding.ActivityMainBinding

private const val ZERO_VALUE = 0
private const val PERCENT_VALUE = 100

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.buttonPlus.setOnClickListener {
            hideKeyboard()
            addTipPercentage()
        }

        binding.buttonMinus.setOnClickListener {
            hideKeyboard()
            removeTipPercentage()
        }
    }

    private fun addTipPercentage() {
        var stringPercentValue = binding.textViewTipPercent.text
        var intPercentValue = stringPercentValue.substring(ZERO_VALUE, stringPercentValue.length - 1).toInt()

        if (stringPercentValue.isNotEmpty() &&
            binding.editTextBillAmount.text.isNotEmpty() &&
            intPercentValue < PERCENT_VALUE
        ) {
            intPercentValue++
            stringPercentValue = "$intPercentValue%"
            binding.textViewTipPercent.text = stringPercentValue

            val doubleBill = roundTwoDigits(binding.editTextBillAmount.text.toString().toDouble())
            val doubleTip = roundTwoDigits(intPercentValue.toDouble() / PERCENT_VALUE * doubleBill)
            val doubleTotal = roundTwoDigits(doubleBill + doubleTip)

            binding.textViewTotalKr.text = "$doubleTotal kr"
            binding.textViewBillKr.text = "$doubleBill kr"
            binding.textViewTipKr.text = "$doubleTip kr"
        } else if (intPercentValue == PERCENT_VALUE) {
            sendMessage(R.string.tip_amount_cant_be_more_then_100)
        } else {
            sendMessage(R.string.bill_amount_cant_be_empty)
        }
    }

    private fun removeTipPercentage() {
        var stringPercentValue = binding.textViewTipPercent.text
        var intPercentValue = stringPercentValue.substring(ZERO_VALUE, stringPercentValue.length - 1).toInt()

        if (stringPercentValue.isNotEmpty() &&
            binding.editTextBillAmount.text.isNotEmpty() &&
            intPercentValue > ZERO_VALUE
        ) {
            intPercentValue--
            stringPercentValue = "$intPercentValue%"
            binding.textViewTipPercent.text = stringPercentValue

            val doubleBill = roundTwoDigits(binding.editTextBillAmount.text.toString().toDouble())
            val doubleTip = roundTwoDigits(intPercentValue.toDouble() / PERCENT_VALUE * doubleBill)
            val doubleTotal = roundTwoDigits(doubleBill + doubleTip)

            binding.textViewTotalKr.text = "$doubleTotal kr"
            binding.textViewBillKr.text = "$doubleBill kr"
            binding.textViewTipKr.text = "$doubleTip kr"
        } else if (intPercentValue == PERCENT_VALUE) {
            sendMessage(R.string.tip_amount_cant_be_less_then_0)
        } else {
            sendMessage(R.string.bill_amount_cant_be_empty)
        }
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideKeyboard() {
        val activityView: View? = this.currentFocus
        if (activityView != null) {
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activityView.getWindowToken(), ZERO_VALUE)
        }
    }

    private fun roundTwoDigits(doubleNumber: Double): Double {
        val decimalFormat = DecimalFormat("#.##")
        val formattedNumber = decimalFormat.format(doubleNumber).toDouble()
        return formattedNumber
    }
}
