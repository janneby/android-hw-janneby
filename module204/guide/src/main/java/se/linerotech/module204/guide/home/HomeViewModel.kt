package se.linerotech.module204.guide.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state: StateFlow<HomeState> = _state
    private val fakeDB = mutableListOf<Task>()

    init {
        retrieveNotDoneTasks()
    }

    private fun retrieveNotDoneTasks() {
        viewModelScope.launch {
            delay(2000)
            _state.value = HomeState.TaskList(
                emptyList()
            )
        }
    }

    fun onTaskCreated(taskName: String) {
        val task = Task(
            id = UUID.randomUUID().toString(),
            name = taskName,
            isCompleted = false,
        )

        fakeDB.add(0, task)
        val newList = fakeDB.filter { !it.isCompleted }
        _state.value = HomeState.TaskList(newList)
    }

    fun onCheckChanged(task: Task) {
        val indexOfItem = fakeDB.indexOfFirst { it.id == task.id }

        fakeDB.removeAt(indexOfItem)
        val updatedTask = task.copy(isCompleted = !task.isCompleted)
        fakeDB.add(indexOfItem, updatedTask)

        val newList = fakeDB.filter { !it.isCompleted }

        _state.value = HomeState.TaskList(newList)
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel() as T
                }
            }
        }
    }
}
