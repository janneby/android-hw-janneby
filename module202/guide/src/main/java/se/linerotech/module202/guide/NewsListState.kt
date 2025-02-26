package se.linerotech.module202.guide

sealed class NewsListState {
    object Loading : NewsListState()
    data class Success(val news: List<News>) : NewsListState()
    object Failure : NewsListState()
}
