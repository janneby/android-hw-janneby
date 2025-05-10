package se.linerotech.module203.project2.incidents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module203.project2.api.RetroFitClient
import se.linerotech.module203.project2.incidents.api.IncidentDTO

class IncidentsViewModel : ViewModel() {
    private val _state = MutableStateFlow<IncidentsState>(IncidentsState.Loading)
    val state: StateFlow<IncidentsState> = _state

    init {
        retrieveIncidents()
    }

    private fun retrieveIncidents() {
        getRetrofitIncidents().enqueue(object : Callback<List<IncidentDTO>> {
            override fun onResponse(
                call: Call<List<IncidentDTO>>,
                response: Response<List<IncidentDTO>>
            ) {
                if (isSuccessful(response)) {
                    val dto = response.body() ?: return
                    _state.value = IncidentsState.Success(
                        incidents = incidents(dto),
                    )
                } else {
                    _state.value = IncidentsState.Failure
                }
            }

            override fun onFailure(call: Call<List<IncidentDTO>>, t: Throwable) {
                _state.value = IncidentsState.Failure
            }
        })
    }

    private fun getRetrofitIncidents(): Call<List<IncidentDTO>> {
        return RetroFitClient.instance.events()
    }

    private fun incidents(dtoList: List<IncidentDTO>): List<Incident> {
        return dtoList.map { Incident(it) }
    }

    private fun isSuccessful(response: Response<List<IncidentDTO>>): Boolean {
        return response.isSuccessful && response.body() != null
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return IncidentsViewModel() as T
                }
            }
        }
    }
}
