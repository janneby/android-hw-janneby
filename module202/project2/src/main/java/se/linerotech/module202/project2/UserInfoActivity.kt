package se.linerotech.module202.project2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module202.project2.api.RetroFitClient
import se.linerotech.module202.project2.api.UserResultDto
import se.linerotech.module202.project2.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    // private val viewModel: UserInfoViewModel by viewModels { UserInfoViewModel.factory(popularUser().userId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        retrieveUserInformation()
    }

    private fun retrieveUserInformation() {
        RetroFitClient.instance.userInformation(
            user = popularUser()?.id ?: "No Username"
        ).enqueue(object : Callback<UserResultDto> {
            override fun onResponse(call: Call<UserResultDto>, response: Response<UserResultDto>) {
                if (response.isSuccessful && response.body() != null) {
                    val currentUser = response.body()!!
                    showUserInformation(currentUser)
                } else {
                    Toast.makeText(
                        this@UserInfoActivity,
                        "UserInfoActivity - onResponse error",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<UserResultDto>, t: Throwable) {
                Toast.makeText(
                    this@UserInfoActivity,
                    "UserInfoActivity - onFailure error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun configureToolbar() {
        setSupportActionBar((binding.toolbar))
        supportActionBar?.apply {
            val user = popularUser()
            title = user?.id ?: "Unknown User" // Fallback title
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.arrow_back)
        }
    }

    private fun showUserInformation(userInfo: UserResultDto) {
        loadImage(url = userInfo.avatarUrl)
        binding.textViewUserName.text = userInfo.name
        binding.textViewUserCountry.text = userInfo.location

        binding.textViewFollowers.text = userInfo.followers.toString()
        binding.textViewFollowing.text = userInfo.following.toString()
        binding.textViewRepositories.text = userInfo.publicRepos.toString()

        binding.textViewAbout.text = userInfo.bio

        binding.textViewTwitterUserName.text = getString(R.string.at) + userInfo.twitterUsername
        binding.textViewWebpage.text = userInfo.blog
        if (userInfo.hireable == null) {
            binding.textViewHireStatus.text = "Not hireable"
        } else {
            binding.textViewHireStatus.text = userInfo.hireable.toString()
        }

        binding.textViewCompanyName.text = userInfo.company
    }

    private fun loadImage(url: String?) {
        Glide
            .with(binding.imageViewUser)
            .load(url)
            .placeholder(R.drawable.github_logo)
            .centerCrop()
            .into(binding.imageViewUser)
    }

    private fun popularUser(): PopularItem? {
        return intent.getParcelableExtra(KEY_USER)
    }

//    private fun showProgressBar() {
//        binding.progressBar.visibility = View.VISIBLE
//    }
//
//    private fun showErrorMessage() {
//        Toast.makeText(this, "UserInfo - error", Toast.LENGTH_LONG).show()
//    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val KEY_USER = "KEY_USER"

        fun intent(context: Context, user: PopularItem): Intent {
            val intent = Intent(context, UserInfoActivity::class.java)
            intent.putExtra(KEY_USER, user)
            return intent
        }
    }
}
