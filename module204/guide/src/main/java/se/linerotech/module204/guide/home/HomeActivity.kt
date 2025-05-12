package se.linerotech.module204.guide.home

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.databinding.ActivityHomeBinding
import se.linerotech.module204.guide.userprofile.UpdateProfileActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val addTaskSheet = AddTaskBottomSheet(::addTask)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        configureClickListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.updateProfile) {
            openUpdateProfile()
            true
        } else {
            false
        }
    }

    private fun configureToolbar() {
        supportActionBar?.apply {
            setTitle(R.string.tasks)
            setBackgroundDrawable(ColorDrawable(getColor(R.color.charcoal_blue)))
        }
    }

    private fun openUpdateProfile() {
        startActivity(UpdateProfileActivity.intent(this))
    }

    private fun configureClickListeners() {
        binding.buttonAddTask.setOnClickListener {
            addTaskSheet.show(supportFragmentManager, AddTaskBottomSheet.TAG)
        }
    }

    private fun addTask(task: String) {
        Toast.makeText(this, task, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
