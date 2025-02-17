package se.linerotech.module205.project2

import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class RandomPictureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_image)
        // Getting the breed data
        val imageViewRandomDog: ImageView = findViewById(R.id.imageViewRandomDog)
        val imageViewRandomDog2: ImageView = findViewById(R.id.imageViewRandomDog2)
        val imageViewRandomDog3: ImageView = findViewById(R.id.imageViewRandomDog3)

        val breedImageData = intent?.getParcelableArrayListExtra<Parcelable>(KEY_REPOSITORY_DATA2)

        breedImageData?.let {
            // Load 3 random dog images
            Glide.with(this)
                .load(it.toArray()[0])
                .into(imageViewRandomDog)

            Glide.with(this)
                .load(it.toArray()[1])
                .into(imageViewRandomDog2)

            Glide.with(this)
                .load(it.toArray()[2])
                .into(imageViewRandomDog3)
        }
    }
    companion object {
        const val KEY_REPOSITORY_DATA2 = "keyRepositoryData"
    }
}
