package se.linerotech.module202.guide

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val image: Int,
)
