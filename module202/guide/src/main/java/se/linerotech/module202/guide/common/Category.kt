package se.linerotech.module202.guide.common

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val image: Int,
)
