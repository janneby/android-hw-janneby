package se.linerotech.module203.guide.tours

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.tours.dto.TourDataDto

class ToursViewModel(resources: Resources?) : ViewModel() {
    private val _state = MutableStateFlow<ToursState>(ToursState.Loading)
    val state: StateFlow<ToursState> = _state

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<TourDataDto> = moshi.adapter(TourDataDto::class.java)

    init {
        tours(resources)
    }

    private fun tours(resources: Resources?) {
        val tours = tourData(resources)

        if (tours == null || randomFailure()) {
            _state.value = ToursState.Failure
        } else {
            _state.value = ToursState.Success(tours)
        }
    }

    private fun tourData(resources: Resources?): List<Tour>? {
        if (resources == null) return null

        val json = resources.openRawResource(R.raw.tours).bufferedReader().use { it.readText() }
        return try {
            val dto = jsonAdapter.fromJson(json)
            dto?.tourDtos?.map { Tour(it) }
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
                    return ToursViewModel(resources) as T
                }
            }
        }
    }
}
