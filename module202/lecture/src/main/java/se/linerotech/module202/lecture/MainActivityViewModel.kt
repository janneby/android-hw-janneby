package se.linerotech.module202.lecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 1.Define the states
// 2.Produce the data
sealed class CountryListState {
    data object Loading : CountryListState()
    data object Failure : CountryListState()
    data class Success(
        val country: List<Country>
    ) : CountryListState()
}

class MainActivityViewModel : ViewModel() {
    private val _state = MutableStateFlow<CountryListState>(CountryListState.Loading)
    val state: StateFlow<CountryListState> = _state

    init {
        retrieveCountries()
    }

    private fun retrieveCountries() {
        RetrofitClient.instance.allCountries().enqueue(object : Callback<MainCountryDTO> {
            override fun onResponse(
                call: Call<MainCountryDTO>,
                response: Response<MainCountryDTO>
            ) {
                if (response.isSuccessful) {
                    val dtos: List<MainCountryDTO.Country> = response.body()!!.countries
                    val countries: List<Country> = dtos.map { dto ->
                        Country(
                            flagUrl = dto.flag.large ?: "",
                            countryName = dto.name ?: "",
                            worldRegion = dto.region ?: "",
                            population = dto.population.toString() ?: "",
                            area = dto.area.toString() ?: "",
                            capital = dto.capital ?: "",
                            callingCode = dto.callingCode ?: "",
                            topLevelDomain = dto.topLevelDomain.toString() ?: "",
                        )
                    }.sortedBy { it.countryName }

                    _state.value = CountryListState.Success(countries)
                } else {
                    // Log.e("MainActivity", "Error retrieving data: ${response.code()}")
                    _state.value = CountryListState.Failure
                }
            }

            override fun onFailure(call: Call<MainCountryDTO>, t: Throwable) {
                // Unable to connect with the API
                // Log.e("MainActivity", "Error: ${t.message}")
                _state.value = CountryListState.Failure
            }
        })
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainActivityViewModel() as T
                }
            }
        }
    }
}
