package se.linerotech.module201.guide

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
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
            sendMessage(message = R.string.twitter_login)
        }

        buttonGoogle?.setOnClickListener {
            sendMessage(message = R.string.google_login)
        }

        buttonFacebook?.setOnClickListener {
            sendMessage(message = R.string.facebook_login)
        }

        textViewForgotPassword?.setOnClickListener {
            sendMessage(message = R.string.forgot_password)
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
            sendMessage(message = R.string.successful_login)
        }
    }

    private fun notifyInvalidEmail() {
        editTextEmail?.error = getString(R.string.invalid_email)
    }

    private fun notifyInvalidPassword() {
        editTextPassword?.error = getString(R.string.password_cannot_be_empty)
    }

    private fun isEmailValid(): Boolean {
        val email = editTextEmail?.text.toString().trim()
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(): Boolean {
        val password = editTextPassword?.text.toString().trim()
        return password.isNotEmpty()
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
