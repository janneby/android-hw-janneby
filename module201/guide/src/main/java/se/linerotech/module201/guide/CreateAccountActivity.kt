package se.linerotech.module201.guide

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {
    private var buttonCreateAccount: Button? = null
    private var editTextUsername: EditText? = null
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        configureToolbar()
        initializeViews()
        setClickListeners()
    }

    private fun configureToolbar() {
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun initializeViews() {
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount)
        editTextUsername = findViewById(R.id.editTextUserName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    private fun setClickListeners() {
        buttonCreateAccount?.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        if (!isUsernameValid()) {
            notifyInvalidUsername()
        }

        if (!isEmailValid()) {
            notifyInvalidEmail()
        }

        if (!isPasswordValid()) {
            notifyInvalidPassword()
        }

        if (isUsernameValid() && isEmailValid() && isPasswordValid()) {
            sendMessage(message = R.string.account_created)
        }
    }

    private fun notifyInvalidUsername() {
        editTextUsername?.error = getString(R.string.username_cannot_by_empty)
    }

    private fun notifyInvalidEmail() {
        editTextEmail?.error = getString(R.string.invalid_email)
    }

    private fun notifyInvalidPassword() {
        editTextPassword?.error = getString(R.string.password_cannot_be_empty)
    }

    private fun isUsernameValid(): Boolean {
        val username = editTextUsername?.text.toString().trim()
        return username.isNotEmpty()
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
