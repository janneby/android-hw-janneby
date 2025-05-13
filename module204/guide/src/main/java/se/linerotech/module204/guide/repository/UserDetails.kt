package se.linerotech.module204.guide.repository

import android.util.Patterns

data class UserDetails(
    val name: String,
    val email: String,
    val username: String,
) {

    fun isValid(): Boolean {
        return isNameValid() && isEmailValid() && isUsernameValid()
    }

    fun isNameValid(): Boolean {
        return name.trim().isNotEmpty()
    }

    fun isUsernameValid(): Boolean {
        return username.trim().isNotEmpty()
    }

    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
