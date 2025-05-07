package se.linerotech.module202.project2.languageRepository

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import se.linerotech.module202.project2.R
import se.linerotech.module202.project2.common.PopularItem
import se.linerotech.module202.project2.databinding.ActivityRepositoryListBinding

class LanguageRepositoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRepositoryListBinding
    private val viewModel: LanguageRepositoryViewModel by viewModels {
        LanguageRepositoryViewModel.factory(
            getRepositoryName()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        observeState()
    }

    private fun configureToolbar() {
        setSupportActionBar((binding.toolbar))
        supportActionBar?.apply {
            this.title = getString(R.string.repositories)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.arrow_back)
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle((Lifecycle.State.CREATED)) {
                viewModel.state.collect { state ->
                    when (state) {
                        LanguageRepositoryState.Loading -> showProgressBar()
                        is LanguageRepositoryState.Success -> {
                            showRepositories(repositories = state.repositories)
                        }
                        LanguageRepositoryState.Failure -> showErrorMessage()
                    }
                }
            }
        }
    }

    private fun showRepositories(repositories: List<LanguageRepository>) {
        hideProgressBar()

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = LanguageRepositoryRecyclerViewAdapter(
                items = repositories,
                onCellClicked = ::showRepositoryDetails
            )
            layoutManager = LinearLayoutManager(this@LanguageRepositoryActivity)
            setHasFixedSize(true)
        }
    }

    private fun showRepositoryDetails(languageRepository: LanguageRepository) {
        Toast.makeText(this, "${languageRepository.title} was clicked!", Toast.LENGTH_SHORT).show()
    }

    private fun getRepositoryName(): PopularItem {
        return intent.getParcelableExtra(KEY_ITEM)!!
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showErrorMessage() {
        Toast.makeText(
            this,
            getString(R.string.error_unable_to_retrieve_repositories),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val KEY_ITEM = "KEY_ITEM"

        fun intent(context: Context, item: PopularItem): Intent {
            val intent = Intent(context, LanguageRepositoryActivity::class.java)
            intent.putExtra(KEY_ITEM, item)
            return intent
        }
    }
}
