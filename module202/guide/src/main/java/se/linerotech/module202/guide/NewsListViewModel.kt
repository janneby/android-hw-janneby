package se.linerotech.module202.guide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsListViewModel : ViewModel() {
    private val _state = MutableStateFlow<NewsListState>(NewsListState.Loading)
    val state: StateFlow<NewsListState> = _state

    init {
        viewModelScope.launch {
            delay(2000)
            val randomNumber = (1..10).random()
            if (randomNumber % 2 == 0) {
                _state.value = NewsListState.Success(news = dummyNewsData())
            } else {
                _state.value = NewsListState.Failure
            }
        }
    }

    private fun dummyNewsData(): List<News> {
        // return emptyList()
        return listOf(
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
            News(
                title = "This is the title",
                date = "2000-01-01",
                source = "SOURCE",
                image = "img"
            ),
        )
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NewsListViewModel() as T
                }
            }
        }
    }
}
