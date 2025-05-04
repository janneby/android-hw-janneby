package se.linerotech.module203.guide.flights

sealed class FlightsState {
    object Loading : FlightsState()
    data class Success(val flights: List<Flight>) : FlightsState()
    object Failure : FlightsState()
}
