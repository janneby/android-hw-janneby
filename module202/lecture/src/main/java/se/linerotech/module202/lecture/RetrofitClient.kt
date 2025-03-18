package se.linerotech.module202.lecture

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    // private const val baseUrl = "https://hlinero.pythonanywhere.com/countries"
    private const val baseUrl = "https://hlinero.pythonanywhere.com/"

    val instance: Endpoint by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl((baseUrl))
            .build()

        retrofit.create(Endpoint::class.java)
    }
}
