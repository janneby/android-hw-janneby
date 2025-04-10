package se.linerotech.module203.guide.tours

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ToursViewModel : ViewModel() {
    private val _state = MutableStateFlow<ToursState>(ToursState.Loading)
    val state: StateFlow<ToursState> = _state

    init {
        tours()
    }

    private fun tours() {
        val tours = listOf(
            Tour(
                name = "Name 1",
                location = "Location 1",
                days = 1,
                cost = 10,
                image = ""
            ),
            Tour(
                name = "Name 2",
                location = "Location 2",
                days = 1,
                cost = 10,
                image = ""
            ),
            Tour(
                name = "Name 3",
                location = "Location 3",
                days = 1,
                cost = 10,
                image = ""
            ),
        )

        if (randomFailure()) {
            _state.value = ToursState.Failure
        } else {
            _state.value = ToursState.Success(tours)
        }
    }

    private fun randomFailure(): Boolean {
        return (1..2).random() == 2
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ToursViewModel() as T
                }
            }
        }
    }
}
