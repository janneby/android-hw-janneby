package se.linerotech.module204.guide.UserProfile

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        configureClickListener()
    }

    private fun configureToolbar() {
        supportActionBar?.apply {
            setTitle(getString(R.string.create_profile))
            setBackgroundDrawable(ColorDrawable(getColor(R.color.charcoal_blue)))
        }
    }

    private fun configureClickListener() {
        binding.buttonCreateProfile.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        if (!isNameValid()) {
            notifyInvalidName()
        }

        if (!isUsernameValid()) {
            notifyInvalidUsername()
        }

        if (!isEmailValid()) {
            notifyInvalidEmail()
        }

        if (isNameValid() && isUsernameValid() && isEmailValid()) {
            sendMessage(message = R.string.sucessful_login)
        }
    }

    private fun isNameValid(): Boolean {
        return binding.editTextName.text.trim().isNotEmpty()
    }

    private fun isUsernameValid(): Boolean {
        return binding.editTextUsername.text.trim().isNotEmpty()
    }

    private fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(binding.editTextEmail.text).matches()
    }

    private fun notifyInvalidName() {
        binding.editTextName.error = getString(R.string.name_cannot_be_empty)
    }

    private fun notifyInvalidUsername() {
        binding.editTextUsername.error = getString(R.string.username_cannot_be_empty)
    }

    private fun notifyInvalidEmail() {
        binding.editTextEmail.error = getString(R.string.invalid_email_format)
    }

    private fun sendMessage(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
