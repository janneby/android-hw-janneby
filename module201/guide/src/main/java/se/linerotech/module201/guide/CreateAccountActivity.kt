package se.linerotech.module201.guide

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module201.guide.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        setClickListeners()
    }

    private fun configureToolbar() {
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setClickListeners() {
        binding.buttonCreateAccount.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        val username = binding.editTextUsername.text.toString()

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
        binding.editTextUsername.error = getString(R.string.username_cannot_by_empty)
    }

    private fun notifyInvalidEmail() {
        binding.editTextEmail.error = getString(R.string.invalid_email)
    }

    private fun notifyInvalidPassword() {
        binding.editTextPassword.error = getString(R.string.password_cannot_be_empty)
    }

    private fun isUsernameValid(): Boolean {
        val username = binding.editTextUsername.text.toString().trim()
        return username.isNotEmpty()
    }

    private fun isEmailValid(): Boolean {
        val email = binding.editTextEmail.text.toString().trim()
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(): Boolean {
        val password = binding.editTextPassword.text.toString().trim()
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
