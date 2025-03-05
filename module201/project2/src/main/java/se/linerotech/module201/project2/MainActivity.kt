package se.linerotech.module201.project2

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.project2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialTipsyValues()
        setListeners()
    }

    private fun setInitialTipsyValues() {
        setTipsyValues(billAmount = ZERO_INT_VALUE, percentValue = ZERO_INT_VALUE)
    }

    private fun setListeners() {
        binding.editTextBillAmount.addTextChangedListener {
            if (getBillAmount().isNotEmpty()) {
                setTipsyValues(
                    billAmount = getBillAmount().toInt(),
                    percentValue = getPercent(),
                )
            } else {
                setInitialTipsyValues()
            }
        }

        binding.buttonPlus.setOnClickListener {
            hideKeyboard()
            changeTipPercentage(condition = getString(R.string.addpercent))
        }

        binding.buttonMinus.setOnClickListener {
            hideKeyboard()
            changeTipPercentage(condition = getString(R.string.subtractpercent))
        }
    }

    private fun getPercent(): Int {
        return binding.textViewTipPercent.text.substring(
            ZERO_INT_VALUE,
            binding.textViewTipPercent.text.length - 1
        ).toInt()
    }

    private fun getBillAmount(): String {
        return binding.editTextBillAmount.text.toString()
    }

    private fun changeTipPercentage(condition: String) {
        var intPercentValue = getPercent()

        if (getBillAmount().isNotEmpty()) {
            if (condition == getString(R.string.addpercent) && intPercentValue < PERCENT_MAX_VALUE
            ) {
                intPercentValue++
                setTipsyValues(billAmount = getBillAmount().toInt(), percentValue = intPercentValue)
            } else if (condition == getString(R.string.subtractpercent) && intPercentValue > ZERO_INT_VALUE) {
                intPercentValue--
                setTipsyValues(billAmount = getBillAmount().toInt(), percentValue = intPercentValue)
            } else if (intPercentValue == PERCENT_MAX_VALUE) {
                sendMessage(R.string.tip_amount_cant_be_more_then_100)
            } else if (intPercentValue == ZERO_INT_VALUE) {
                sendMessage(R.string.tip_amount_cant_be_less_then_0)
            }
        } else {
            sendMessage(R.string.bill_amount_cant_be_empty)
        }
    }

    private fun setTipsyValues(billAmount: Int, percentValue: Int) {
        val doubleTip = roundTwoDigits(percentValue.toDouble() / PERCENT_MAX_VALUE * billAmount)
        val doubleTotal = roundTwoDigits(billAmount + doubleTip)

        binding.textViewTipPercent.text = percentValue.toString() + "%"
        binding.textViewTotalKr.text = doubleTotal.toString() + " kr"
        binding.textViewBillKr.text = billAmount.toString() + " kr"
        binding.textViewTipKr.text = doubleTip.toString() + " kr"
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideKeyboard() {
        val activityView: View? = this.currentFocus
        if (activityView != null) {
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activityView.getWindowToken(), ZERO_INT_VALUE)
        }
    }

    private fun roundTwoDigits(doubleNumber: Double): Double {
        val decimalFormat = DecimalFormat("#.##")
        val formattedNumber = decimalFormat.format(doubleNumber).toDouble()
        return formattedNumber
    }

    companion object {
        private const val ZERO_INT_VALUE = 0
        private const val PERCENT_MAX_VALUE = 100
    }
}
