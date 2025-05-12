package se.linerotech.module204.guide.home

sealed class HomeState {
    object Loading : HomeState()
    data class TaskList(val tasks: List<Task>) : HomeState()
}
