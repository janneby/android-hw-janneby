package se.linerotech.module203.lecture.onboarding

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class OnboardingState(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    val showButtonGetStarted: Boolean,
    val onGetStartedClicked: () -> Unit
) : Parcelable
