package se.linerotech.module201.guide

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    private var buttonLogin: Button? = null
    private var buttonCreateAccount: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        buttonLogin = findViewById(R.id.buttonLogin)
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount)

        buttonLogin?.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        buttonCreateAccount?.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))
        }
    }
}
