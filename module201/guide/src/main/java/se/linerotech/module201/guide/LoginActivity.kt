package se.linerotech.module201.guide

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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

        // My actionbar was black, no matter what I did so I changed background to white until I solve it
        // At least a litle better looking, but I lost the onclick effect
        // supportActionBar?.setBackgroundDrawable(getDrawable(R.color.white))

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        buttonTwitter = findViewById(R.id.buttonTwitter)
        buttonGoogle = findViewById(R.id.buttonGoogle)
        buttonFacebook = findViewById(R.id.buttonFacebook)
        textViewForgotPassword = findViewById((R.id.textViewForgotPassword))
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonTwitter?.setOnClickListener {
            Toast.makeText(this, "Twitter Login", Toast.LENGTH_SHORT).show()
        }

        buttonGoogle?.setOnClickListener {
            Toast.makeText(this, "Google Login", Toast.LENGTH_LONG).show()
        }

        buttonFacebook?.setOnClickListener {
            Toast.makeText(this, "Facebook Login", Toast.LENGTH_SHORT).show()
        }

        textViewForgotPassword?.setOnClickListener {
            Toast.makeText(this, "Forgot password", Toast.LENGTH_SHORT).show()
        }

        buttonLogin?.setOnClickListener {
            val email = editTextEmail?.text.toString().trim()
            val password = editTextPassword?.text.toString().trim()

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail?.error = "Invalid email"
                // Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            }
            if (password.isEmpty()) {
                editTextPassword?.error = "Password field cannot be - Empty"
                // Toast.makeText(this, "Password field cannot be - Empty", Toast.LENGTH_SHORT).show()
            }

            if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.isNotEmpty()) {
                Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show()
            }

            /*
            Get inputted email
            Get imputted password

            if (email is invalid) {
                Show error message
            } else if (password is invalid) {
                Show error message
            } else {
                Show the success message
            }
            */
        }
    }

    // This code below is closing the login-window(LoginActivity)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
