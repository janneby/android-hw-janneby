package se.linerotech.module202.project2.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("users/{user}")
    fun userInformation(
        @Path("user") user: String,
    ): Call<UserResultDto>
}
