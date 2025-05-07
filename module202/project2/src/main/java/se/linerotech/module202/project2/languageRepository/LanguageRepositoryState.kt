package se.linerotech.module202.project2.languageRepository

sealed class LanguageRepositoryState {
    data object Loading : LanguageRepositoryState()
    data class Success(val repositories: List<LanguageRepository>) : LanguageRepositoryState()
    object Failure : LanguageRepositoryState()
}
