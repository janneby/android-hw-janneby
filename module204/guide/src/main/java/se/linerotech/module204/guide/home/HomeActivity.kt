package se.linerotech.module204.guide.home

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.R
import se.linerotech.module204.guide.databinding.ActivityHomeBinding
import se.linerotech.module204.guide.repository.database.DatabaseInstance
import se.linerotech.module204.guide.userprofile.UpdateProfileActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val addTaskSheet = AddTaskBottomSheet(::addTask)
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModel.factory(dao = DatabaseInstance.instance(this).taskDao())
    }
    private lateinit var adapter: TaskRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        configureRecyclerView()
        configureClickListeners()
        observerViewModel()
    }

    private fun configureToolbar() {
        supportActionBar?.apply {
            setTitle(R.string.tasks)
            setBackgroundDrawable(ColorDrawable(getColor(R.color.charcoal_blue)))
        }
    }

    private fun configureRecyclerView() {
        adapter = TaskRecyclerViewAdapter(onTaskCheckedListener = { task ->
            viewModel.onCheckChanged(task, toggleButtonCurrentState())
        })
        binding.recyclerView.apply {
            adapter = this@HomeActivity.adapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
            setHasFixedSize(false)
        }
    }

    private fun configureClickListeners() {
        binding.buttonAddTask.setOnClickListener {
            addTaskSheet.show(supportFragmentManager, AddTaskBottomSheet.TAG)
        }
        binding.buttonNotDone.setOnClickListener {
            viewModel.onNotDoneClicked()
        }
        binding.buttonDone.setOnClickListener {
            viewModel.onDoneClicked()
        }
    }

    private fun observerViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        HomeState.Loading -> showProgressbar()
                        is HomeState.TaskList -> showTaskList(tasks = state.tasks)
                    }
                }
            }
        }
    }

    private fun showProgressbar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showTaskList(tasks: List<Task>) {
        binding.progressBar.visibility = View.GONE
        binding.toggleButtonGroup.visibility = View.VISIBLE
        binding.buttonAddTask.visibility = View.VISIBLE

        if (tasks.isEmpty()) {
            binding.layoutEmptyList.root.visibility = View.VISIBLE
        } else {
            binding.layoutEmptyList.root.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }

        adapter.differ.submitList(tasks)
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

    private fun openUpdateProfile() {
        startActivity(UpdateProfileActivity.intent(this))
    }

    private fun addTask(taskName: String) {
        viewModel.onTaskCreated(taskName, toggleButtonCurrentState())
    }

    private fun toggleButtonCurrentState(): ToggleButtonState {
        return if (binding.toggleButtonGroup.checkedButtonId == R.id.buttonDone) {
            ToggleButtonState.Done
        } else {
            ToggleButtonState.NotDone
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
