package se.linerotech.module203.project1.onboarding

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class OnboardingState(
    @StringRes val title: Int,
    @StringRes val subtitle: Int,
    @DrawableRes val image: Int,
    val showGetStarted: Boolean,
    val onGetStartedClicked: () -> Unit
) : Parcelable
