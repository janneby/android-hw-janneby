package se.linerotech.module202.guide.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetroFitClient {
    private const val baseUrl = "https://newsdata.io/api/1/"

    val instance: Endpoint by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl((baseUrl))
            .build()

        retrofit.create(Endpoint::class.java)
    }
}
