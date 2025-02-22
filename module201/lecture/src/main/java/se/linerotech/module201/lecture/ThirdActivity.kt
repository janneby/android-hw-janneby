package se.linerotech.module201.lecture

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import se.linerotech.module201.lecture.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.euroConversion.text = "0.00€"
        binding.usDollarConversion.text = "0.00$"

        setTextChangedListener()
    }

    private fun setTextChangedListener() {
        binding.editTextEnterAmount.addTextChangedListener { text ->
            val currentAmountOfSwedishKrona = if(text.isNullOrEmpty()) 0.0 else text.toString().toDouble()
            if(currentAmountOfSwedishKrona < 10000000) {
                binding.euroConversion.text = String.format("${String.format("%.2f", currentAmountOfSwedishKrona * 0.096)}€")
                binding.usDollarConversion.text = String.format("${String.format("%.2f", currentAmountOfSwedishKrona * 0.088)}$")
            }
            Toast.makeText(this, "Swedish Krona to high, set a lower value!", Toast.LENGTH_SHORT).show()
        }
    }
}
