package se.linerotech.module204.guide.userprofile

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.databinding.ActivityProfileBinding
import se.linerotech.module204.guide.repository.datastore.UserDetails
import se.linerotech.module204.guide.repository.datastore.UserDetailsRepository

abstract class ProfileActivity : AppCompatActivity() {
    protected lateinit var binding: ActivityProfileBinding
    protected lateinit var userDetailsRepository: UserDetailsRepository
    private val viewModel: ProfileViewModel by viewModels {
        ProfileViewModel.factory(userDetailsRepository)
    }

    abstract val toolbarTitle: Int
    abstract val showBackArrow: Boolean
    abstract val buttonTitle: Int
    abstract fun onFinishedSaving()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)
        userDetailsRepository = UserDetailsRepository(this)

        configureToolbar()
        configureClickListener()
        setButtonTitle()
        observeViewModel()
    }

    private fun configureToolbar() {
        supportActionBar?.apply {
            setTitle(toolbarTitle)
            setBackgroundDrawable(ColorDrawable(getColor(R.color.charcoal_blue)))
            setDisplayHomeAsUpEnabled(showBackArrow)
            setHomeAsUpIndicator(R.drawable.back_arrow_icon)
        }
    }

    private fun configureClickListener() {
        binding.buttonProfile.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val username = binding.editTextUsername.text.toString()

            val userDetails = UserDetails(name = name, email = email, username = username)

            viewModel.save(userDetails)
        }
    }

    private fun setButtonTitle() {
        binding.buttonProfile.setText(buttonTitle)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        ProfileState.Idle -> {}
                        ProfileState.SuccessSaving -> onFinishedSaving()
                        ProfileState.ErrorSaving -> showSavingError()
                        is ProfileState.InvalidUserDetails -> notifyInvalidUserDetails(state)
                    }
                }
            }
        }
    }

    private fun showSavingError() {
        Toast.makeText(this@ProfileActivity, R.string.unable_to_save_data, Toast.LENGTH_LONG).show()
    }

    private fun notifyInvalidUserDetails(state: ProfileState.InvalidUserDetails) {
        if (!state.isNameValid) {
            binding.editTextName.error = getString(R.string.name_cannot_be_empty)
        }

        if (!state.isEmailValid) {
            binding.editTextEmail.error = getString(R.string.invalid_email_format)
        }

        if (!state.isUsernameValid) {
            binding.editTextUsername.error = getString(R.string.username_cannot_be_empty)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
