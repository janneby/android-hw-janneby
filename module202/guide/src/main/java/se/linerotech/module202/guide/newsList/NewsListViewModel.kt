package se.linerotech.module202.guide.newsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module202.guide.api.ArticleDTO
import se.linerotech.module202.guide.api.Credentials
import se.linerotech.module202.guide.api.NewsResultDTO
import se.linerotech.module202.guide.api.RetroFitClient
import se.linerotech.module202.guide.common.News

@Suppress("UNCHECKED_CAST")
class NewsListViewModel(private val categoryName: String) : ViewModel() {
    private val _state = MutableStateFlow<NewsListState>(NewsListState.Loading)
    val state: StateFlow<NewsListState> = _state

    init {
        retrieveNews()
    }

    private fun retrieveNews() {
        headLines().enqueue(object : Callback<NewsResultDTO> {
            override fun onResponse(call: Call<NewsResultDTO>, response: Response<NewsResultDTO>) {
                if (isSuccessful(response)) {
                    _state.value = NewsListState.Success(news(response.body()!!.results!!))
                } else {
                    _state.value = NewsListState.Failure
                }
            }

            override fun onFailure(call: Call<NewsResultDTO>, t: Throwable) {
                _state.value = NewsListState.Failure
            }
        })
    }

    private fun isSuccessful(response: Response<NewsResultDTO>): Boolean {
        return response.isSuccessful && response.body() != null && response.body()!!.results != null
    }

    private fun headLines(): Call<NewsResultDTO> {
        return RetroFitClient.instance.news(
            apiKey = Credentials.newsDataIoKey1,
            language = "en",
            country = "us",
            category = categoryName
        )
    }

    private fun news(articles: List<ArticleDTO>): List<News> {
        return articles.map { dto ->
            News(dto)
        }
    }

    companion object {
        fun factory(categoryName: String): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NewsListViewModel(categoryName) as T
                }
            }
        }
    }
}
