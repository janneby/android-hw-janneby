package se.linerotech.module205.project1


import com.google.gson.annotations.SerializedName

data class CocktailName(
    @SerializedName("drinks")
    val drinks: List<Drink>? = listOf()
)