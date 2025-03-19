package se.linerotech.module202.project1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
//    @GET("https://api.weatherapi.com/v1/current.json")

    @GET("current.json")
    fun cityWeather(
        @Query("key")apikey: String,
        @Query("q")q: String,
    ): Call<CityWeatherDTO>
}
