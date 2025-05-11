package se.linerotech.module204.guide.userprofile

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.databinding.ActivityProfileBinding
import se.linerotech.module204.guide.home.HomeActivity
import se.linerotech.module204.guide.repository.UserDetails
import se.linerotech.module204.guide.repository.UserDetailsRepository

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var userDetailsRepository: UserDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDetailsRepository = UserDetailsRepository(this)
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
        var isValid = true

        if (!binding.editTextName.text.trim().isNotEmpty()) {
            binding.editTextName.error = getString(R.string.name_cannot_be_empty)
            isValid = false
        }

        if (!binding.editTextUsername.text.trim().isNotEmpty()) {
            binding.editTextUsername.error = getString(R.string.username_cannot_be_empty)
            isValid = false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(binding.editTextEmail.text).matches()) {
            binding.editTextEmail.error = getString(R.string.invalid_email_format)
            isValid = false
        }

        if (isValid) {
            saveUserDetails()
        }
    }

    private fun saveUserDetails() {
        lifecycleScope.launch {
            val saveResult = userDetailsRepository.put(
                userDetails = UserDetails(
                    binding.editTextName.text.toString(),
                    binding.editTextName.text.toString(),
                    binding.editTextUsername.text.toString(),
                )
            )
            if (saveResult) {
                startActivity(HomeActivity.intent(this@ProfileActivity))
                finish()
            } else {
                Toast.makeText(
                    this@ProfileActivity,
                    R.string.unable_to_save_data,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }
}
