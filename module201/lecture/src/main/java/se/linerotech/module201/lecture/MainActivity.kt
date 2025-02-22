package se.linerotech.module201.lecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.lecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonContinue.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
    }
}
