package se.linerotech.module204.guide.routing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.home.HomeActivity
import se.linerotech.module204.guide.repository.UserDetailsRepository
import se.linerotech.module204.guide.userprofile.ProfileActivity

class RoutingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splash = installSplashScreen()

        setContentView(R.layout.activity_routing)

        splash.setKeepOnScreenCondition { true }
        lifecycleScope.launch {
            val nextActivity = if (areUserDetailsAvailable()) {
                HomeActivity.intent(this@RoutingActivity)
            } else {
                ProfileActivity.intent(this@RoutingActivity)
            }

            startActivity(nextActivity)
            finish()
        }
    }

    private suspend fun areUserDetailsAvailable(): Boolean {
        val userDetailsRepository = UserDetailsRepository(this)
        val userDetails = userDetailsRepository.get()

        return userDetails != null
    }
}
