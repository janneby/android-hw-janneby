package se.linerotech.module205.project1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.linerotech.module205.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.Namesearch.setOnClickListener() {
            getCocktail()
        }
    }

    private fun getCocktail() {
        // Get cocktail name from edittext
        val cocktailName = binding.nameOfCocktail.text.trim().toString().lowercase()
        if (cocktailName.isEmpty()) {
            Toast.makeText(this, "Name cant be empty", Toast.LENGTH_SHORT).show()
        } else {
            RetrofitClient
                .instance
                .getDrinkInfo(cocktailName)
                .enqueue(object : Callback<CocktailName> {
                    override fun onResponse(
                        call: Call<CocktailName>,
                        response: Response<CocktailName>
                    ) {
                        val drinks = response.body()?.drinks!!
                        val firstDrink = drinks[0]
                        val listOfIngr = firstDrink.strInstructions
                        val a = 90
                    }

                    override fun onFailure(call: Call<CocktailName>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Failed To retrieve data", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}

/*




    5.  Display the Data
        -Pass the data to the other activity
        -Create view of the recycler item
        -create a recyclerview adapter


 */
