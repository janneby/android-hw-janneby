package se.linerotech.module205.project3.backend

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import se.linerotech.module205.project3.model.NewsData

interface NewsApiService {

    @GET("everything")
    fun searchNews(
        @Query("q") query: String?,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String,
    ): Call<NewsData>
}
