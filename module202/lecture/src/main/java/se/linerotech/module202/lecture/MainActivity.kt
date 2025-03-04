package se.linerotech.module202.lecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import se.linerotech.module202.lecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = CountryRecyclerViewAdapter(
                countries = getDummyDataList(),
                onCountryClickListener = {},
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    private fun getDummyDataList(): List<Country> {
        return listOf(
            Country(name = "Sweden", flag = ""),
            Country(name = "Norway", flag = ""),
            Country(name = "Finland", flag = ""),
            Country(name = "Denmark", flag = ""),
            Country(name = "Estland", flag = ""),
            Country(name = "Lettland", flag = ""),
            Country(name = "Litauen", flag = ""),
            Country(name = "Island", flag = ""),
        )
    }
}
