package se.linerotech.module205.project2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import se.linerotech.module205.project2.models.AllBreeds
import se.linerotech.module205.project2.models.Breed
import se.linerotech.module205.project2.models.RandomImage

interface Endpoint {
    @GET("breeds/list/all")
    fun getListOfBreeds(): Call<AllBreeds>

    @GET("breeds/image/random/3")
    fun getRandomImages(): Call<RandomImage>

    @GET("breed/{breed}/images")
    fun getBreedImages(@Path("breed") breed: String): Call<Breed>
}