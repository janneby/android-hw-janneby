package se.linerotech.module202.project1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(cities())
    val state: StateFlow<List<City>> = _state

    private fun cities(): List<City> {
        return listOf(
            City(id = "agra", cityName = R.string.agra, cityImage = R.drawable.agra),
            City(id = "barcelona", cityName = R.string.barcelona, cityImage = R.drawable.barcelona),
            City(id = "beijing", cityName = R.string.beijing, cityImage = R.drawable.beijing),
            City(id = "sydney", cityName = R.string.sydney, cityImage = R.drawable.sydney),
            City(id = "paris", cityName = R.string.paris, cityImage = R.drawable.paris),
            City(id = "new_york", cityName = R.string.new_york, cityImage = R.drawable.new_york),
            City(id = "london", cityName = R.string.london, cityImage = R.drawable.london),
            City(id = "rio_de_janeiro", cityName = R.string.rio_de_janeiro, cityImage = R.drawable.rio_de_janeiro),
            City(id = "moscow", cityName = R.string.moscow, cityImage = R.drawable.moscow),
            City(id = "rome", cityName = R.string.rome, cityImage = R.drawable.rome),
        )
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel() as T
                }
            }
        }
    }
}
