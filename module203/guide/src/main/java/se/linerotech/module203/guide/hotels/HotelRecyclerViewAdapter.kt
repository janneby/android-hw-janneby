package se.linerotech.module203.guide.hotels

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.RecyclerCellHotelBinding

class HotelRecyclerViewAdapter(
    private val items: List<Hotel>,
    private val onCellClicked: (Hotel) -> Unit,
) : RecyclerView.Adapter<HotelRecyclerViewAdapter.HotelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        return HotelViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HotelViewHolder(
        private val binding: RecyclerCellHotelBinding,
        private val context: Context,
        private val onCellClicked: (Hotel) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hotel: Hotel) {
            binding.title.text = hotel.name
            binding.costPerNight.text = context.getString(R.string.sek_night, hotel.pricePerNight)
            binding.stars.text = context.resources.getQuantityString(R.plurals.stars, hotel.stars, hotel.stars)
            binding.reviews.text = context.resources.getQuantityString(R.plurals.reviews, hotel.reviews, hotel.reviews)
            binding.hotelCard.setOnClickListener { onCellClicked(hotel) }
            loadImage(hotel.image)
        }

        private fun loadImage(url: String) {
            Glide
                .with(binding.image)
                .load(url)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(CORNER_RADIUS)))
                .into(binding.image)
        }

        companion object {
            private const val CORNER_RADIUS = 10
            fun create(parent: ViewGroup, onCellClicked: (Hotel) -> Unit): HotelViewHolder {
                val binding = RecyclerCellHotelBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return HotelViewHolder(binding = binding, parent.context, onCellClicked = onCellClicked)
            }
        }
    }
}
