package se.linerotech.module205.project1


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {

    @GET("search.php")
    fun getDrinkInfo(@Query("s")nameOfDrink: String): Call<CocktailName>

}