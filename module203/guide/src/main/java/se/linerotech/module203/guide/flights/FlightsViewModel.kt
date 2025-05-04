package se.linerotech.module203.guide.flights

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.flights.dto.FlightDataDto

class FlightsViewModel(resources: Resources?) : ViewModel() {
    private val _state = MutableStateFlow<FlightsState>(FlightsState.Loading)
    val state: StateFlow<FlightsState> = _state

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<FlightDataDto> = moshi.adapter(FlightDataDto::class.java)

    init {
        flights(resources)
    }

    private fun flights(resources: Resources?) {
        val flights = flightData(resources)

        if (flights == null || randomFailure()) {
            _state.value = FlightsState.Failure
        } else {
            _state.value = FlightsState.Success(flights)
        }
    }

    private fun flightData(resources: Resources?): List<Flight>? {
        if (resources == null) return null

        val json = resources.openRawResource(R.raw.flights).bufferedReader().use { it.readText() }
        return try {
            val dto = jsonAdapter.fromJson(json)
            dto?.flightDtos?.map { Flight(it) }
        } catch (exception: java.lang.Exception) {
            Log.e("Error during flightData operation", exception.message.toString())
            throw exception // Rethrow the original exception
        }
    }

    private fun randomFailure(): Boolean {
        return (1..2).random() == 2
    }

    companion object {
        fun factory(resources: Resources?): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return FlightsViewModel(resources) as T
                }
            }
        }
    }
}
