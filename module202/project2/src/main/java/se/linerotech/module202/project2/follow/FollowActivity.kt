package se.linerotech.module202.project2.follow

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
import se.linerotech.module202.project2.databinding.ActivityFollowBinding
import se.linerotech.module202.project2.user.UserInfoActivity

class FollowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFollowBinding
    private val viewModel: FollowViewModel by viewModels {
        FollowViewModel.factory(
            getLoginName().id,
            getLoginName().type
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        observerState()
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            if (getLoginName().type == getString(R.string.followers)) {
                this.title = getString(R.string.followers)
            } else if (getLoginName().type == getString(R.string.following)) {
                this.title = getString(R.string.following)
            } else {
                this.title = getString(R.string.unknown_user)
            }

            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.arrow_back)
        }
    }

    private fun observerState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        is FollowState.Loading -> showProgressBar()
                        is FollowState.Success -> {
                            showFollow(follow = (state as FollowState.Success).follows)
                        }
                        is FollowState.Failure -> showErrorMessage()
                    }
                }
            }
        }
    }

    private fun showFollow(follow: List<Follow>) {
        hideProgressBar()

        binding.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = FollowRecyclerViewAdapter(items = follow, onCellClicked = ::showFollowerDetails)
            layoutManager = LinearLayoutManager(this@FollowActivity)
            setHasFixedSize(true)
        }
    }

    private fun showFollowerDetails(follow: Follow) {
        val user = PopularItem(follow.login ?: getString(R.string.unknown_user))
        val intent = UserInfoActivity.intent(this@FollowActivity, user)
        startActivity(intent)
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
            getString(R.string.error_unable_to_retrieve_followers),
            Toast.LENGTH_LONG
        ).show()
    }

    private fun getLoginName(): PopularItem {
        return intent.getParcelableExtra(KEY_USERLOGIN)!!
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val KEY_USERLOGIN = "KEY_USERLOGIN"

        fun intent(context: Context, userLogin: PopularItem): Intent {
            val intent = Intent(context, FollowActivity::class.java)
            intent.putExtra(KEY_USERLOGIN, userLogin)
            return intent
        }
    }
}
