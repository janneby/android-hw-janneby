package se.linerotech.module203.guide.hotels

sealed class HotelsState {
    object Loading : HotelsState()
    data class Success(val hotels: List<Hotel>) : HotelsState()
    object Failure : HotelsState()
}
