package se.linerotech.module202.lecture

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("countries")
    fun allCountries(): Call<MainCountryDTO>
}
