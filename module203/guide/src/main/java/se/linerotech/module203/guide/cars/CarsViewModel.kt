package se.linerotech.module203.guide.cars

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.cars.dto.CarDataDto

class CarsViewModel(resources: Resources?) : ViewModel() {
    private val _state = MutableStateFlow<CarsState>(CarsState.Loading)
    val state: StateFlow<CarsState> = _state

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<CarDataDto> = moshi.adapter(CarDataDto::class.java)

    init {
        cars(resources)
    }

    private fun cars(resources: Resources?) {
        val cars = carData(resources)

        if (cars == null || randomFailure()) {
            _state.value = CarsState.Failure
        } else {
            _state.value = CarsState.Success(cars)
        }
    }

    private fun carData(resources: Resources?): List<Car>? {
        if (resources == null) return null

        val json = resources.openRawResource(R.raw.cars).bufferedReader().use { it.readText() }
        return try {
            val dto = jsonAdapter.fromJson(json)
            dto?.carDtos?.map { Car(it) }
        } catch (exception: java.lang.Exception) {
            null
        }
    }

    private fun randomFailure(): Boolean {
        return (1..2).random() == 2
    }

    companion object {
        fun factory(resources: Resources?): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CarsViewModel(resources) as T
                }
            }
        }
    }
}
