package se.linerotech.module203.project2.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AboutViewModel : ViewModel() {
    private val _state = MutableStateFlow(abouts())
    val state: StateFlow<List<About>> = _state

    private fun abouts(): List<About> {
        return listOf(
            About(title = "Source", description = "Polisen.se", url = "https://polisen.se/"),
            About(
                title = "Rules",
                description = "Open Data Rules",
                url = "https://polisen.se/om-polisen/om-webbplatsen/oppna-data/regler-for-oppna-data/"
            ),
            About(
                title = "Police Station Services",
                description = "Available Servicese",
                url = "https://polisen.se/om-polisen/om-webbplatsen/oppna-data/api-over-polisstationer/"
            ),
            About(
                title = "Incidents",
                description = "Types of incidents",
                url = "https://polisen.se/om-polisen/om-webbplatsen/oppna-data/api-over-polisens-handelser/"
            ),
        )
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return AboutViewModel() as T
                }
            }
        }
    }
}
