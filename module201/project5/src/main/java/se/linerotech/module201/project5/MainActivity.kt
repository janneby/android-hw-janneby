package se.linerotech.module201.project5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.project5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setOnTextChangedListeners() {


    }


}
