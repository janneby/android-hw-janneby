package se.linerotech.module201.project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var buttonLogin: Button? = null
    private var registerButton: Button? = null
    private var facebookButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        setClickListeners()
    }

    private fun initializeViews() {
        buttonLogin = findViewById(R.id.buttonLogin)
        registerButton = findViewById(R.id.buttonRegister)
        facebookButton = findViewById(R.id.buttonFacebook)
    }

    private fun setClickListeners() {
        buttonLogin?.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        registerButton?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        facebookButton?.setOnClickListener {
            sendMessage(message = R.string.connect_with_facebook)
        }
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
