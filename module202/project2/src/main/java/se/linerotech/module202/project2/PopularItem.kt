package se.linerotech.module202.project2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularItem(
    val id: String
) : Parcelable
