package se.linerotech.module202.project2.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module202.project2.api.RetroFitClient
import se.linerotech.module202.project2.api.UserRepositoryDto.UserRepositoryDtoItem
import se.linerotech.module202.project2.common.PopularItem

class UserRepositoryViewModel(private val repositoryName: PopularItem) : ViewModel() {
    private val _state = MutableStateFlow<UserRepositoryState>(UserRepositoryState.Loading)
    val state: StateFlow<UserRepositoryState> = _state

    init {
        retrieveRepositories()
    }

    private fun retrieveRepositories() {
        getRetrofitRepos().enqueue(object : Callback<List<UserRepositoryDtoItem>> {
            override fun onResponse(
                call: Call<List<UserRepositoryDtoItem>>,
                response: Response<List<UserRepositoryDtoItem>>
            ) {
                if (isSuccessful(response)) {
                    val userRepoItems = response.body() ?: emptyList()
                    val repositories = repos(userRepoItems)
                    _state.value = UserRepositoryState.Success(
                        repositories = repositories,
                    )
                }
            }

            override fun onFailure(call: Call<List<UserRepositoryDtoItem>>, t: Throwable) {
                _state.value = UserRepositoryState.Failure
            }
        })
    }

    private fun repos(repos: List<UserRepositoryDtoItem>): List<UserRepository> {
        return repos.map { dto -> UserRepository(dto) }
    }

    private fun getRetrofitRepos(): Call<List<UserRepositoryDtoItem>> {
        return RetroFitClient.instance.userRepoInformation(
            user = repositoryName.id
        )
    }

    private fun isSuccessful(response: Response<List<UserRepositoryDtoItem>>): Boolean {
        return response.isSuccessful && response.body() != null
    }

    companion object {
        fun factory(repositoryName: PopularItem): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return UserRepositoryViewModel(repositoryName) as T
                }
            }
        }
    }
}
