package se.linerotech.module204.guide.userprofile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.repository.UserDetails

class UpdateProfileActivity : ProfileActivity() {
    override val toolbarTitle: Int = R.string.update_profile
    override val showBackArrow: Boolean = true
    override val buttonTitle: Int = R.string.update_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showUserDetails()
    }

    override fun onFinishedSaving() {
        finish()
    }

    private fun showUserDetails() {
        lifecycleScope.launch {
            userDetails()?.let { details ->
                binding.editTextName.setText(details.name)
                binding.editTextEmail.setText(details.email)
                binding.editTextUsername.setText(details.username)
            }
        }
    }

    private suspend fun userDetails(): UserDetails? {
        return userDetailsRepository.get()
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, UpdateProfileActivity::class.java)
        }
    }
}
