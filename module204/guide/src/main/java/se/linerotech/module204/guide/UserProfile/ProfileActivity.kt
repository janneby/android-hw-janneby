package se.linerotech.module204.guide.UserProfile

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module204.guide.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        configureToolbar()
    }

    private fun configureToolbar() {
        supportActionBar?.apply {
            setTitle(getString(R.string.create_profile))
            setBackgroundDrawable(ColorDrawable(getColor(R.color.charcoal_blue)))
        }
    }
}
