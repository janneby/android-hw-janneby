package se.linerotech.module205.project2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response
import se.linerotech.module205.project2.databinding.ActivityMainBinding
import se.linerotech.module205.project2.models.AllBreeds
import se.linerotech.module205.project2.models.Breed
import se.linerotech.module205.project2.models.RandomImage
import java.util.ArrayList

class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {

    // Defining binding variables
    private lateinit var binding: ActivityMainBinding
    private var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Initializing the imm
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Setting edit text listener
        binding.mainActivityEditText.setOnEditorActionListener(this)

        // Setting the on click listeners
        binding.mainActivityButton.setOnClickListener {
            randomImage()
        }
    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        return if (p0 == binding.mainActivityEditText) {
            // Get the breed name from the edit text
            val breedName = binding.mainActivityEditText.text?.trim().toString()

            // Check if the edit text is not empty
            if (breedName.isEmpty() || breedName.isBlank()) {
                // SHow a message to the user
                binding.mainActivityEditText.error = getString(R.string.cannot_be_empty)
            } else {
                // Hide the keyboard
                imm?.hideSoftInputFromWindow(binding.mainActivityEditText.windowToken, 0)

                // Start the progress bar
                binding.progressBar.visibility = View.VISIBLE

                // Make the request
                getBreedName(breedName)
            }
            true
        } else {
            false
        }
    }

    private fun randomImage() {
        RetrofitClient
            .instance
            .getRandomImages()
            .enqueue(
                object : retrofit2.Callback<RandomImage> {
                    override fun onFailure(call: Call<RandomImage>, t: Throwable) {
                        // Log the error
                        Log.e(TAG, "Error getting breed name: ${t.localizedMessage}")

                        // Show message to the user
                        Toast.makeText(
                            this@MainActivity,
                            R.string.unable_to_get_picture,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(call: Call<RandomImage>, response: Response<RandomImage>) {
                        if (response.isSuccessful) {
                            val breedImages = response.body()?.message as ArrayList<String>
                            breedImages.let {
                                val intent =
                                    Intent(this@MainActivity, RandomPictureActivity::class.java)

                                // Pass the data to the activity
                                intent.putExtra(RandomPictureActivity.KEY_REPOSITORY_DATA2, it)

                                startActivity(intent)
                            }
                        }
                    }
                }

            )
    }

    private fun getBreedName(breed: String) {
        RetrofitClient
            .instance
            .getBreedImages(breed.lowercase())
            .enqueue(object : retrofit2.Callback<Breed> {

                override fun onFailure(call: Call<Breed>, t: Throwable) {
                    // Log the error
                    Log.e(TAG, "Error getting breed name: ${t.localizedMessage}")

                    // Show message to the user
                    Toast.makeText(
                        this@MainActivity,
                        R.string.unable_to_get_breed,
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(call: Call<Breed>, response: Response<Breed>) {
                    // Hide the progress bar
                    binding.progressBar.visibility = View.INVISIBLE

                    if (response.isSuccessful) {
                        // Get the breed images
                        val breedImages = response.body()?.message as ArrayList<String>

                        // Passing the data to the next activity
                        breedImages.let {
                            // Create an intent
                            val intent = Intent(this@MainActivity, BreedPictureActivity::class.java)

                            // Pass the data to the activity
                            intent.putExtra(BreedPictureActivity.KEY_REPOSITORY_DATA, it)

                            // Start the new activity
                            startActivity(intent)
                        }
                    } else {
                        // Created a message based on the error code
                        val message = when (response.code()) {
                            500 -> R.string.internal_server_error
                            401 -> R.string.unauthorized
                            403 -> R.string.forbidden
                            404 -> R.string.user_not_found
                            else -> R.string.try_another_user
                        }

                        // Show message to user
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                        Log.e(TAG, getString(message))
                    }
                }
            })
    }

    private fun breedsRecyclerView() {
        RetrofitClient
            .instance
            .getListOfBreeds()
            .enqueue(object : retrofit2.Callback<AllBreeds> {
                override fun onFailure(call: Call<AllBreeds>, t: Throwable) {
                    // Log the error
                    Log.e(TAG, "Error getting breed list: ${t.localizedMessage}")

                    // Show message to the user
                    Toast.makeText(
                        this@MainActivity,
                        R.string.unable_to_read_breed_list,
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onResponse(call: Call<AllBreeds>, response: Response<AllBreeds>) {
                    // Hide the progress bar
                    binding.progressBar.visibility = View.INVISIBLE
                    if (response.isSuccessful) {
                        val breedList = response.body()?.message as ArrayList<String>

                        // Pass the data to the activity
                        breedList.let {
                            val intent = Intent(this@MainActivity, AllBreedsActivity::class.java)

                            intent.putExtra(AllBreedsActivity.KEY_REPOSITORY_DATA3, it)

                            // Start the new activity
                            startActivity(intent)
                        }
                    } else {
                        // Created a message based on the error code
                        val message = when (response.code()) {
                            500 -> R.string.internal_server_error
                            401 -> R.string.unauthorized
                            403 -> R.string.forbidden
                            404 -> R.string.user_not_found
                            else -> R.string.try_another_user
                        }
                        // Show message to user
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()

                        Log.e(TAG, getString(message))
                    }
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.allBreeds -> {
                breedsRecyclerView()

                true
            }
            else -> {
                false
            }
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
