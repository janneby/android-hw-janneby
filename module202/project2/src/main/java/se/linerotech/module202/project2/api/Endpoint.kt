package se.linerotech.module202.project2.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {

    //  https://api.github.com/users/hlinero
    @GET("users/{user}")
    fun userInformation(
        @Path("user") user: String,
    ): Call<UserResultDto>

    // https://api.github.com/users/hlinero/followers
    @GET("users/{user}/followers")
    fun followerInformation(
        @Path("user") user: String,
    ): Call<List<FollowResultDtoItem>>

    // https://api.github.com/users/hlinero/following
    @GET("users/{user}/following")
    fun followingInformation(
        @Path("user") user: String,
    ): Call<List<FollowResultDtoItem>>

    // https://api.github.com/users/hlinero/following
    @GET("users/{user}/repos")
    fun userRepoInformation(
        @Path("user") user: String,
    ): Call<List<UserRepositoryDto.UserRepositoryDtoItem>>

    // https://api.github.com/search/repositories?q=language:kotlin
    @GET("search/repositories")
    fun languageInformation(
        @Query("q") language: String,
    ): Call<LanguageResultDto>
}
