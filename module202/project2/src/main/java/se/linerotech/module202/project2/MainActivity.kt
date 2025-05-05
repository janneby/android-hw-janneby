package se.linerotech.module202.project2

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import se.linerotech.module202.project2.R.color.white
import se.linerotech.module202.project2.databinding.ActivityMainBinding
import se.linerotech.module202.project2.databinding.LayoutChipBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        showPopularItems()
        setClickListeners()
    }

    private fun showPopularItems() {
        showPopularLanguages(
            listOf(
                PopularItem(id = "Kotlin"),
                PopularItem(id = "Python"),
                PopularItem(id = "Java"),
                PopularItem(id = "C++"),
            )
        )
        showPopularOrgs(
            listOf(
                PopularItem(id = "JetBrains"),
                PopularItem(id = "google"),
                PopularItem(id = "github"),
            )
        )
        showPopularUsers(
            listOf(
                PopularItem(id = "hlinero"),
                PopularItem(id = "torvalds"),
                PopularItem(id = "gaeron"),
            )
        )
    }

    private fun showPopularLanguages(popularItems: List<PopularItem>) {
        popularItems.forEach { popularLanguage ->
            val chip = createUserChip(popularItem = popularLanguage)
            chip.setChipBackgroundColorResource(white)
            chip.setChipStrokeColorResource(R.color.black)
            chip.chipStrokeWidth = 1.0f
            binding.popularLanguagesChipGroup.addView(chip)
        }
    }

    private fun showPopularOrgs(popularItems: List<PopularItem>) {
        popularItems.forEach { popularOrg ->
            val chip = createUserChip(popularItem = popularOrg)
            chip.setChipBackgroundColorResource(white)
            chip.setChipStrokeColorResource(R.color.black)
            chip.chipStrokeWidth = 1.0f
            binding.popularOrganisationsChipGroup.addView(chip)
        }
    }

    private fun showPopularUsers(popularItems: List<PopularItem>) {
        popularItems.forEach { popularUser ->
            val chip = createUserChip(popularItem = popularUser)
            chip.setChipBackgroundColorResource(white)
            chip.setChipStrokeColorResource(R.color.black)
            chip.chipStrokeWidth = 1.0f
            binding.popularUserChipGroup.addView(chip)
        }
    }

    private fun createUserChip(popularItem: PopularItem): Chip {
        val chip = LayoutChipBinding.inflate(layoutInflater).root
        chip.text = popularItem.id
        chip.setOnClickListener {
            showUserInfoScreen(popularItem = popularItem)
        }
        return chip
    }

    private fun showUserInfoScreen(popularItem: PopularItem) {
        val user = PopularItem(popularItem.id)
        val intent = UserInfoActivity.intent(this@MainActivity, user)
        startActivity(intent)
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
    }

    private fun setClickListeners() {
        binding.editTextGitHubUsername.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    val input = binding.editTextGitHubUsername.text.toString()
                    showUserInfoScreen(popularItem = PopularItem(input))
                    binding.editTextGitHubUsername.text.clear()
                    true
                }
                else -> false
            }
        }
    }
}
