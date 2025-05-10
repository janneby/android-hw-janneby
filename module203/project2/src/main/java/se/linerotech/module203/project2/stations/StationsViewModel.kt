package se.linerotech.module203.project2.stations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module203.project2.api.RetroFitClient
import se.linerotech.module203.project2.stations.api.StationDTO

class StationsViewModel : ViewModel() {
    private val _state = MutableStateFlow<StationsState>(StationsState.Loading)
    val state: StateFlow<StationsState> = _state

    init {
        retrieveIncidents()
    }

    private fun retrieveIncidents() {
        getRetrofitIncidents().enqueue(object : Callback<List<StationDTO>> {

            override fun onResponse(
                call: Call<List<StationDTO>>,
                response: Response<List<StationDTO>>
            ) {
                if (isSuccessful(response)) {
                    val dto = response.body() ?: return
                    _state.value = StationsState.Success(
                        stations = stations(dto),
                    )
                } else {
                    _state.value = StationsState.Failure
                }
            }

            override fun onFailure(call: Call<List<StationDTO>>, t: Throwable) {
                _state.value = StationsState.Failure
            }
        })
    }

    private fun getRetrofitIncidents(): Call<List<StationDTO>> {
        return RetroFitClient.instance.stations()
    }

    private fun stations(dtoList: List<StationDTO>): List<Station> {
        return dtoList.map { Station(it) }
    }

    private fun isSuccessful(response: Response<List<StationDTO>>): Boolean {
        return response.isSuccessful && response.body() != null
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return StationsViewModel() as T
                }
            }
        }
    }
}
