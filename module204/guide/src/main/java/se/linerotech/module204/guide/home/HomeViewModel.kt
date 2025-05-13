package se.linerotech.module204.guide.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import se.linerotech.module204.guide.repository.database.TaskDao
import se.linerotech.module204.guide.repository.database.TaskEntity
import java.util.UUID

class HomeViewModel(private val dao: TaskDao) : ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state: StateFlow<HomeState> = _state

    init {
        retrieveNotDoneTasks()
    }

    private fun retrieveNotDoneTasks() {
        viewModelScope.launch {
            val tasks = dao.notCompletedTasks().map(::Task)
            _state.value = HomeState.TaskList(tasks)
        }
    }

    fun onTaskCreated(taskName: String, toggleButtonCurrentState: ToggleButtonState) {
        viewModelScope.launch {
            val task = Task(
                id = UUID.randomUUID().toString(),
                name = taskName,
                isCompleted = false,
            )

            dao.insert(TaskEntity(task))

            val newList = if (toggleButtonCurrentState == ToggleButtonState.Done) {
                dao.completedTasks()
            } else {
                dao.notCompletedTasks()
            }.map(::Task)

            _state.value = HomeState.TaskList(newList)
        }
    }

    fun onCheckChanged(task: Task, toggleButtonCurrentState: ToggleButtonState) {
        viewModelScope.launch {
            val updatedTask = task.copy(isCompleted = !task.isCompleted)
            dao.update(TaskEntity(updatedTask))

            val newList = if (toggleButtonCurrentState == ToggleButtonState.Done) {
                dao.completedTasks()
            } else {
                dao.notCompletedTasks()
            }.map(::Task)

            _state.value = HomeState.TaskList(newList)
        }
    }

    fun onDoneClicked() {
        viewModelScope.launch {
            val newList = dao.completedTasks().map(::Task)
            _state.value = HomeState.TaskList(newList)
        }
    }

    fun onNotDoneClicked() {
        viewModelScope.launch {
            val newList = dao.notCompletedTasks().map(::Task)
            _state.value = HomeState.TaskList(newList)
        }
    }

    companion object {
        fun factory(dao: TaskDao): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(dao) as T
                }
            }
        }
    }
}
