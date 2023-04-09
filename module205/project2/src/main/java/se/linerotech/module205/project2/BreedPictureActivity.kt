package se.linerotech.module205.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import com.bumptech.glide.Glide

class BreedPictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_picture)

        val imageViewDogBreed: ImageView = findViewById(R.id.imageViewDogBreed)

        // Getting the breed data
        val breedImageData = intent?.getParcelableArrayListExtra<Parcelable>(KEY_REPOSITORY_DATA)
        breedImageData?.let {

            // Load a random dog image
            Glide.with(this)
                .load(it.toArray().random())
                .into(imageViewDogBreed)
        }
    }


    companion object {
        const val KEY_REPOSITORY_DATA = "keyRepositoryData"
    }
}