package se.linerotech.module203.project1.library

sealed class LibraryState {
    object Loading : LibraryState()
    data class Success(val library: List<Library>) : LibraryState()
    object Failure : LibraryState()
}
