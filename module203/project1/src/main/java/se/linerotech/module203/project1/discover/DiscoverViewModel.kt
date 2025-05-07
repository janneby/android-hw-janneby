package se.linerotech.module203.project1.discover

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.discover.dto.DiscoverDTO

class DiscoverViewModel(resources: Resources?) : ViewModel() {
        private val _state = MutableStateFlow<DiscoverState>(DiscoverState.Loading)
        val state: StateFlow<DiscoverState> = _state

        private val moshi: Moshi = Moshi.Builder().build()
        private val jsonAdapter: JsonAdapter<DiscoverDTO> = moshi.adapter(DiscoverDTO::class.java)

        init {
            discover(resources)
        }

        private fun discover(resources: Resources?) {
            val discover = discoverData(resources)

            //if (discover == null || randomFailure()) {
            if (discover == null) {
                _state.value = DiscoverState.Failure
            } else {
                _state.value = DiscoverState.Success(discover)
            }
        }

        private fun discoverData(resources: Resources?): List<Discover>? {
            if (resources == null) return null

            val json = resources.openRawResource(R.raw.discover).bufferedReader().use { it.readText() }
            return try {
                val dto = jsonAdapter.fromJson(json)
                dto?.books?.map { it?.let { Discover(it) } }?.filterNotNull()
            } catch (e: Exception) {
                Log.e("DiscoverViewModel", "Error loading data", e)
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
                        return DiscoverViewModel(resources) as T
                    }
                }
            }
        }
    }
