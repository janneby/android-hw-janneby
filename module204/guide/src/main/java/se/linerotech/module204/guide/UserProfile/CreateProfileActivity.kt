package se.linerotech.module204.guide.userprofile

import android.content.Context
import android.content.Intent
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.home.HomeActivity

class CreateProfileActivity : ProfileActivity() {
    override val toolbarTitle: Int = R.string.create_profile
    override val showBackArrow: Boolean = false
    override val buttonTitle: Int = R.string.create_profile

    override fun onFinishedSaving() {
        startActivity(HomeActivity.intent(this))
        finish()
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, CreateProfileActivity::class.java)
        }
    }
}
