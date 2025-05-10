package se.linerotech.module203.project2.incidents

sealed class IncidentsState {
    object Loading : IncidentsState()
    data class Success(val incidents: List<Incident>) : IncidentsState()
    object Failure : IncidentsState()
}
