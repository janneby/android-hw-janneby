package se.linerotech.module203.project1.discover

sealed class DiscoverState {
    object Loading : DiscoverState()
    data class Success(val discover: List<Discover>) : DiscoverState()
    object Failure : DiscoverState()
}
