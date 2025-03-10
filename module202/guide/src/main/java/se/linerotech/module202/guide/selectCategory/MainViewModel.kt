package se.linerotech.module202.guide.selectCategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.linerotech.module202.guide.R
import se.linerotech.module202.guide.common.Category

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(categories())
    val state: StateFlow<List<Category>> = _state

    private fun categories(): List<Category> {
        return listOf(
            Category(id = "top", name = R.string.top, image = R.drawable.general_image),
            Category(id = "business", name = R.string.business, image = R.drawable.business_image),
            Category(id = "entertainment", name = R.string.entertainment, image = R.drawable.entertainment_image),
            Category(id = "health", name = R.string.health, image = R.drawable.health_image),
            Category(id = "sports", name = R.string.sports, image = R.drawable.sports_image),
            Category(id = "science", name = R.string.science, image = R.drawable.science_image),
            Category(id = "technology", name = R.string.technology, image = R.drawable.technology_image),
        )
    }

    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel() as T
                }
            }
        }
    }
}
