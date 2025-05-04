package se.linerotech.module203.guide.hotels

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.hotels.dto.HotelDataDto

class HotelsViewModel(resources: Resources?) : ViewModel() {
    private val _state = MutableStateFlow<HotelsState>(HotelsState.Loading)
    val state: StateFlow<HotelsState> = _state

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<HotelDataDto> = moshi.adapter(HotelDataDto::class.java)

    init {
        hotels(resources)
    }

    private fun hotels(resources: Resources?) {
        val hotels = hotelData(resources)

        if (hotels == null || randomFailure()) {
            _state.value = HotelsState.Failure
        } else {
            _state.value = HotelsState.Success(hotels)
        }
    }

    private fun hotelData(resources: Resources?): List<Hotel>? {
        if (resources == null) return null

        val json = resources.openRawResource(R.raw.hotels).bufferedReader().use { it.readText() }
        return try {
            val dto = jsonAdapter.fromJson(json)
            dto?.hotelDtos?.map { Hotel(it) }
        } catch (exception: java.lang.Exception) {
            Log.e("Error during hotelData operation", exception.message.toString())
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
                    return HotelsViewModel(resources) as T
                }
            }
        }
    }
}
