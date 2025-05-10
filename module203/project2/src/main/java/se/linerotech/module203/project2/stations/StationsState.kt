package se.linerotech.module203.project2.stations

sealed class StationsState {
    object Loading : StationsState()
    data class Success(val stations: List<Station>) : StationsState()
    object Failure : StationsState()
}
