package se.linerotech.module202.project1.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetroFitClient {
    //    @GET("https://api.weatherapi.com/v1/current.json")
    private const val baseUrl = "https://api.weatherapi.com/v1/"

    val instance: Endpoint by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl((baseUrl))
            .build()

        retrofit.create(Endpoint::class.java)
    }
}
