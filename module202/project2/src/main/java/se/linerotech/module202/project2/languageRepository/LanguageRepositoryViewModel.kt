package se.linerotech.module202.project2.languageRepository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module202.project2.api.LanguageResultDto
import se.linerotech.module202.project2.api.RetroFitClient
import se.linerotech.module202.project2.common.PopularItem

class LanguageRepositoryViewModel(private val repositoryName: PopularItem) : ViewModel() {
    private val _state = MutableStateFlow<LanguageRepositoryState>(LanguageRepositoryState.Loading)
    val state: StateFlow<LanguageRepositoryState> = _state

    init {
        retrieveRepositories()
    }

    private fun retrieveRepositories() {
        getRetrofitRepos().enqueue(object : Callback<LanguageResultDto> {
            override fun onResponse(call: Call<LanguageResultDto>, response: Response<LanguageResultDto>) {
                if (isSuccessful(response)) {
                    val repositories = repos(response.body()?.items)
                    _state.value = LanguageRepositoryState.Success(
                        repositories = repositories,
                    )
                } else {
                    _state.value = LanguageRepositoryState.Failure
                }
            }

            override fun onFailure(call: Call<LanguageResultDto>, t: Throwable) {
                _state.value = LanguageRepositoryState.Failure
            }
        })
    }

    private fun repos(repos: List<LanguageResultDto.Item?>?): List<LanguageRepository> {
        return repos?.map { dto ->
            LanguageRepository(dto!!)
        }
            ?: return emptyList()
    }

    private fun getRetrofitRepos(): Call<LanguageResultDto> {
        return RetroFitClient.instance.languageInformation(
            language = "language:" + repositoryName
        )
    }

    private fun isSuccessful(response: Response<LanguageResultDto>): Boolean {
        return response.isSuccessful && response.body() != null
    }

    companion object {
        fun factory(repositoryName: PopularItem): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return LanguageRepositoryViewModel(repositoryName) as T
                }
            }
        }
    }
}
