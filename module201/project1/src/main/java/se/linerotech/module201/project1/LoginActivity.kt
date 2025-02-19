package se.linerotech.module201.project1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonLogin: Button? = null
    private var textViewRegister: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureToolbar()
        initializeViews()
        setClickListeners()
    }

    private fun initializeViews() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewRegister = findViewById(R.id.textViewRegister)
    }

    private fun configureToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    private fun setClickListeners() {
        buttonLogin?.setOnClickListener {
            validateCredentials()
        }

        textViewRegister?.setOnClickListener {
            finish()
            startActivity(Intent(this, RegisterActivity::class.java))
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
            sendMessage(message = getString(R.string.successful_login))
        }
    }

    private fun notifyInvalidEmail() {
        editTextEmail?.error = getString(R.string.invalid_email)
    }

    private fun notifyInvalidPassword() {
        editTextPassword?.error = getString(R.string.password_field_cannot_be_empty)
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

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
