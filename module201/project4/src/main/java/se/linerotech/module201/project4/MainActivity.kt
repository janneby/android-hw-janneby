package se.linerotech.module201.project4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

// How to calculate the monthly payments of a mortgage
// M = p [ i(1 + i)^n ] / [ ((1 + i)^n) – 1]