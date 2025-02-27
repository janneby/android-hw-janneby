package se.linerotech.module202.guide.newsList

import se.linerotech.module202.guide.common.News

sealed class NewsListState {
    object Loading : NewsListState()
    data class Success(val news: List<News>) : NewsListState()
    object Failure : NewsListState()
}
