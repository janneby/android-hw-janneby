package se.linerotech.module202.guide.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)
