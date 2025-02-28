package se.linerotech.module202.guide.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("news")
    fun news(
        @Query("country")country: String,
        @Query("language")language: String,
        @Query("category")category: String,
        @Query("apikey")apiKey: String,
    ): Call<NewsResultDTO>
}
