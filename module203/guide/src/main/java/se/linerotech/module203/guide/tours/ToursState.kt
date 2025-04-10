package se.linerotech.module203.guide.tours

sealed class ToursState {
    object Loading : ToursState()
    data class Success(val tours: List<Tour>) : ToursState()
    object Failure : ToursState()
}
