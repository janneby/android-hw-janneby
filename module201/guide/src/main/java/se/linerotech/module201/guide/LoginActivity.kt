package se.linerotech.module201.guide

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private var buttonTwitter: ImageButton? = null
    private var buttonGoogle: ImageButton? = null
    private var buttonFacebook: ImageButton? = null
    private var textViewForgotPassword: TextView? = null
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureToolbar()
        initializeViews()
        setClickListeners()
    }

    private fun configureToolbar() {
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // My actionbar was black, no matter what I did so I changed background to white until I solve it
        // At least a litle better looking, but I lost the onclick effect
        // supportActionBar?.setBackgroundDrawable(getDrawable(R.color.white))
    }

    private fun initializeViews() {
        buttonTwitter = findViewById(R.id.buttonTwitter)
        buttonGoogle = findViewById(R.id.buttonGoogle)
        buttonFacebook = findViewById(R.id.buttonFacebook)
        textViewForgotPassword = findViewById((R.id.textViewForgotPassword))
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
    }

    private fun setClickListeners() {
        buttonTwitter?.setOnClickListener {
            sendMessage("Twitter Login")
        }

        buttonGoogle?.setOnClickListener {
            sendMessage("Google Login")
        }

        buttonFacebook?.setOnClickListener {
            sendMessage("Facebook Login")
        }

        textViewForgotPassword?.setOnClickListener {
            sendMessage("Forgot password")
        }

        buttonLogin?.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        if (!isEmailValid()) {
            notifyInvalidEmail()
        }

        if (!isPasswordValid()) {
            notifyInvalidPassword()
        }

        if (isEmailValid() && isPasswordValid()) {
            sendMessage("Successful login")
        }
    }

    private fun notifyInvalidEmail() {
        editTextEmail?.error = "Invalid email"
    }

    private fun notifyInvalidPassword() {
        editTextPassword?.error = "Password field cannot be - Empty"
    }

    private fun isEmailValid(): Boolean {
        val email = editTextEmail?.text.toString().trim()
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(): Boolean {
        val password = editTextPassword?.text.toString().trim()
        return password.isNotEmpty()
    }

    private fun sendMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // This code below is closing the login-window(LoginActivity)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
