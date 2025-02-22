package se.linerotech.module201.lecture

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.lecture.databinding.ActivityThirdBinding
import java.util.Locale

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    companion object {
        private const val SEK_MAX_VALUE = 1000000.0
        private const val SEK_EURO_RATE = 0.088
        private const val SEK_DOLLAR_RATE = 0.096
        private const val ZERO_VALUE = 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialCurrencyValues()
        setTextChangedListener()
    }

    private fun setInitialCurrencyValues() {
        setExchangeValues(euros = ZERO_VALUE, dollars = ZERO_VALUE)
    }

    private fun setTextChangedListener() {
        binding.editTextEnterAmount.addTextChangedListener { text ->
            showConversionResults(sekToConvert = retrieveSekAmount(userInput = text))
        }
    }

    private fun showConversionResults(sekToConvert: Double) {
        if (sekToConvert < SEK_MAX_VALUE) {
            setExchangeValues(
                sekToEuro(sek = sekToConvert),
                sekToDollar(sek = sekToConvert)
            )
        } else if (sekToConvert > SEK_MAX_VALUE) {
            // binding.editTextEnterAmount.setText(SEK_MAX_VALUE.toString())
            sendMessage(R.string.swedish_krona_to_high_set_a_lower_value)
        }
    }

    private fun retrieveSekAmount(userInput: CharSequence?): Double {
        return if (userInput.isNullOrEmpty()) ZERO_VALUE else userInput.toString().toDouble()
    }

    private fun setExchangeValues(euros: Double, dollars: Double) {
        binding.euroConversion.text = getString(
            R.string.euro_value,
            String.format(Locale.FRANCE, "%.2f", euros)
        )

        binding.usDollarConversion.text = getString(
            R.string.dollar_value,
            String.format(Locale.US, "%.2f", dollars)
        )
    }

    private fun sekToEuro(sek: Double): Double {
        return sek * SEK_EURO_RATE
    }

    private fun sekToDollar(sek: Double): Double {
        return sek * SEK_DOLLAR_RATE
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
