package se.linerotech.module201.project1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private var editTextUserName: EditText? = null
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonRegister: Button? = null
    private var textViewLogin: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initializeViews()
        setClickListeners()
        configureToolbar()
    }

    private fun initializeViews() {
        editTextUserName = findViewById(R.id.editTextUserName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        textViewLogin = findViewById(R.id.textViewLogin)
    }

    private fun setClickListeners() {
        buttonRegister?.setOnClickListener {
            validateCredentials()
        }

        textViewLogin?.setOnClickListener {
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun validateCredentials() {
        if (!isUserNameValid()) {
            notifyInvalidUserName()
        }
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

    private fun notifyInvalidUserName() {
        editTextUserName?.error = getString(R.string.username_field_cannot_be_empty)
    }

    private fun notifyInvalidEmail() {
        editTextEmail?.error = getString(R.string.invalid_email)
    }

    private fun notifyInvalidPassword() {
        editTextPassword?.error = getString(R.string.password_field_cannot_be_empty)
    }

    private fun isUserNameValid(): Boolean {
        val userName = editTextUserName?.text.toString().trim()
        return userName.isNotEmpty()
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

    private fun configureToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
