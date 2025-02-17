package se.linerotech.module205.project2.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AllBreeds(
    @SerializedName("message")
    val message: List<String>? = null,
    @SerializedName("status")
    val status: String? = null
) : Parcelable
