package se.linerotech.module201.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // My actionbar was black, no matter what I did so I changed background to white until I solve it
        // At least a litle better looking, but I lost the onclick effect
        supportActionBar?.setBackgroundDrawable(getDrawable(R.color.white))

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // This is closing the loginscreen(LoginActivity)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
