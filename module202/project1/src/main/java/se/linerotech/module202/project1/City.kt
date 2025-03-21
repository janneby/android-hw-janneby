package se.linerotech.module202.project1

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val id: String,
    @StringRes val cityName: Int,
    @DrawableRes val cityImage: Int,
) : Parcelable
