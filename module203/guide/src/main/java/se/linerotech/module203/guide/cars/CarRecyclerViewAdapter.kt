package se.linerotech.module203.guide.cars

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.RecyclerCellCarBinding

class CarRecyclerViewAdapter(
    private val items: List<Car>,
    private val onCellClicked: (Car) -> Unit,
) : RecyclerView.Adapter<CarRecyclerViewAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CarViewHolder(
        private val binding: RecyclerCellCarBinding,
        private val context: Context,
        private val onCellClicked: (Car) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car) {
            binding.title.text = car.name
            binding.costPerDay.text = context.getString(R.string.sek_day, car.pricePerDay)
            binding.seats.text = context.resources.getQuantityString(R.plurals.seats, car.seat, car.seat)
            binding.carCard.setOnClickListener { onCellClicked(car) }
            loadImage(car.image)
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
            fun create(parent: ViewGroup, onCellClicked: (Car) -> Unit): CarViewHolder {
                val binding = RecyclerCellCarBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CarViewHolder(binding = binding, parent.context, onCellClicked = onCellClicked)
            }
        }
    }
}
