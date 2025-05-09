package se.linerotech.module203.project1.library

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.project1.R
import java.io.IOException

class LibraryViewModel(resources: Resources?) : ViewModel() {
    private val _state = MutableStateFlow<LibraryState>(LibraryState.Loading)
    val state: StateFlow<LibraryState> = _state

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<LibraryDTO> = moshi.adapter(LibraryDTO::class.java)

    init {
        library(resources)
    }

    private fun library(resources: Resources?) {
        val library = libraryData(resources)

        if (library == null || randomFailure()) {
            _state.value = LibraryState.Failure
        } else {
            _state.value = LibraryState.Success(library)
        }
    }

    private fun libraryData(resources: Resources?): List<Library>? {
        return resources?.let { res ->
            try {
                val json = res.openRawResource(R.raw.library).bufferedReader().use { it.readText() }
                jsonAdapter.fromJson(json)?.categories?.mapNotNull { categoryDto ->
                    categoryDto?.let { Library(it) }
                }
            } catch (e: JsonDataException) {
                Log.e(res.getString(R.string.library_view_model), res.getString(R.string.json_parsing_error), e)
                null
            } catch (e: IOException) {
                Log.e(res.getString(R.string.library_view_model), res.getString(R.string.io_error_loading_data), e)
                null
            }
        }
    }

    private fun randomFailure(): Boolean {
        return (1..2).random() == 2
    }

    companion object {
        fun factory(resources: Resources?): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return LibraryViewModel(resources) as T
                }
            }
        }
    }
}
