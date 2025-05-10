package se.linerotech.module203.project2.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserAgentInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestWithUserAgent = originalRequest.newBuilder()
            .header("User-Agent", "Polisapp/1.0/Jan By, Studerande, Lindome")
            .build()
        return chain.proceed(requestWithUserAgent)
    }
}

object RetroFitClient {
    private const val baseUrl = "https://polisen.se/api/"

    val instance: Endpoint by lazy {
        val client = OkHttpClient.Builder()
            .addInterceptor(UserAgentInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client) // Set the custom OkHttpClient
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        retrofit.create(Endpoint::class.java)
    }
}
