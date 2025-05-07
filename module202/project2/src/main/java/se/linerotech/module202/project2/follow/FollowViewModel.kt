package se.linerotech.module202.project2.follow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module202.project2.api.FollowResultDtoItem
import se.linerotech.module202.project2.api.RetroFitClient

class FollowViewModel(private val userName: String, private val userType: String) : ViewModel() {
    private val _state = MutableStateFlow<FollowState>(FollowState.Loading)
    val state: StateFlow<FollowState> = _state

    init {
        retrieveFollowers()
    }

    private fun retrieveFollowers() {
        getRetrofitFollow().enqueue(object : Callback<List<FollowResultDtoItem>> {
            override fun onResponse(
                call: Call<List<FollowResultDtoItem>>,
                response: Response<List<FollowResultDtoItem>>
            ) {
                if (isSuccessful(response)) {
                    val followerItems = response.body() ?: emptyList()
                    val followers = followers(followerItems)
                    _state.value = FollowState.Success(
                        follows = followers
                    )
                } else {
                    _state.value = FollowState.Failure
                }
            }

            override fun onFailure(call: Call<List<FollowResultDtoItem>>, t: Throwable) {
                _state.value = FollowState.Failure
            }
        })
    }

    private fun followers(followers: List<FollowResultDtoItem>): List<Follow> {
        return followers.map { dto -> Follow(dto) }
    }

    private fun getRetrofitFollow(): Call<List<FollowResultDtoItem>> {
        return when (userType) {
            "Followers" -> RetroFitClient.instance.followerInformation(user = userName)
            else -> RetroFitClient.instance.followingInformation(user = userName)
        }
    }

    private fun isSuccessful(response: Response<List<FollowResultDtoItem>>): Boolean {
        return response.isSuccessful && response.body() != null
    }

    companion object {
        fun factory(userName: String, userType: String): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return FollowViewModel(userName, userType) as T
                }
            }
        }
    }
}
