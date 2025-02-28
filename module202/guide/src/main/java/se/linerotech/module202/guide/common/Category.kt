package se.linerotech.module202.guide.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: String,
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)
