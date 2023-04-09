package se.linerotech.module205.project3.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Source(
    @SerializedName("id")
    val id: String? = null, // Allow null values for id
    @SerializedName("name")
    val name: String = ""
): Parcelable