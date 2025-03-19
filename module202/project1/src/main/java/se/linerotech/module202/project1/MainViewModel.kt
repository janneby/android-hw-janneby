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
            City(cityId = R.string.agra, cityImage = R.drawable.agra),
            City(cityId = R.string.barcelona, cityImage = R.drawable.barcelona),
            City(cityId = R.string.beijing, cityImage = R.drawable.beijing),
            City(cityId = R.string.sydney, cityImage = R.drawable.sydney),
            City(cityId = R.string.paris, cityImage = R.drawable.paris),
            City(cityId = R.string.new_york, cityImage = R.drawable.new_york),
            City(cityId = R.string.london, cityImage = R.drawable.london),
            City(cityId = R.string.rio_de_janeiro, cityImage = R.drawable.rio_de_janeiro),
            City(cityId = R.string.moscow, cityImage = R.drawable.moscow),
            City(cityId = R.string.rome, cityImage = R.drawable.rome),
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
