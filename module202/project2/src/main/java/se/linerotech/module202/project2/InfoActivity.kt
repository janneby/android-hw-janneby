package se.linerotech.module202.project2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module202.project2.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}