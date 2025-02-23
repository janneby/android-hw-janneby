package se.linerotech.module201.project4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.project4.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setTextViewListener()
    }

    private fun setTextViewListener() {
        binding.textViewNext.setOnClickListener() {
            //startActivity(Intent(this,  MainActivity5::class.java))
        }
    }
}