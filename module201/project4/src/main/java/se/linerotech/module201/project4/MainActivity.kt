package se.linerotech.module201.project4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.project4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonOnClickListener()
    }

    private fun setButtonOnClickListener() {
        binding.buttonGetStarted.setOnClickListener() {
            startActivity(Intent(this,  MainActivity2::class.java))
        }
    }
}

// How to calculate the monthly payments of a mortgage
// M = p [ i(1 + i)^n ] / [ ((1 + i)^n) – 1]