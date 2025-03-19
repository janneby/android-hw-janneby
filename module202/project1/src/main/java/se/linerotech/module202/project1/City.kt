package se.linerotech.module202.project1

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    @StringRes val cityId: Int,
    @DrawableRes val cityImage: Int,
) : Parcelable
