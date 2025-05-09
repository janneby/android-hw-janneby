package se.linerotech.module203.project1.profile

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

class ProfileViewModel(resources: Resources?) : ViewModel() {
    private val _state = MutableStateFlow<ProfileState>(ProfileState.Loading)
    val state: StateFlow<ProfileState> = _state

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<ProfileDTO> = moshi.adapter(ProfileDTO::class.java)

    init {
        profile(resources)
    }

    private fun profile(resources: Resources?) {
        val profile = profileData(resources)

        if (profile == null || randomFailure()) {
            _state.value = ProfileState.Failure
        } else {
            _state.value = ProfileState.Success(profile)
        }
    }

    private fun profileData(resources: Resources?): Profile? {
        if (resources == null) return null

        val json = resources.openRawResource(R.raw.profile).bufferedReader().use { it.readText() }
        return try {
            val dto = jsonAdapter.fromJson(json)
            dto?.let { Profile(it) }
        } catch (e: JsonDataException) {
            Log.e(
                resources.getString(R.string.library_view_model),
                resources.getString(R.string.json_parsing_error),
                e
            )
            null
        } catch (e: IOException) {
            Log.e(
                resources.getString(R.string.library_view_model),
                resources.getString(R.string.io_error_loading_data),
                e
            )
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
                    return ProfileViewModel(resources) as T
                }
            }
        }
    }
}
