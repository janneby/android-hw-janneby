package se.linerotech.module201.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        configureToolbar()
    }

    private fun configureToolbar() {
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // My actionbar was black, no matter what I did so I changed background to white until I solve it
        // At least a litle better looking, but I lost the onclick effect
        supportActionBar?.setBackgroundDrawable(getDrawable(R.color.white))
    }

    // This code below is closing the login-window(LoginActivity)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
