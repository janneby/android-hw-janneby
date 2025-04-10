package se.linerotech.module203.guide.tours

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.RecyclerCellTourBinding

class TourRecyclerViewAdapter(
    private val items: List<Tour>,
    private val onCellClicked: (Tour) -> Unit,
) : RecyclerView.Adapter<TourRecyclerViewAdapter.TourViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        return TourViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TourViewHolder(
        private val binding: RecyclerCellTourBinding,
        private val context: Context,
        private val onCellClicked: (Tour) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tour: Tour) {
            binding.title.text = tour.name
            binding.cost.text = context.getString(R.string.sek, tour.cost)
            binding.days.text = context.resources.getQuantityString(R.plurals.days, tour.days, tour.days)
            binding.location.text = tour.location
            binding.tourCard.setOnClickListener { onCellClicked(tour) }
            loadImage(tour.image)
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
            fun create(parent: ViewGroup, onCellClicked: (Tour) -> Unit): TourViewHolder {
                val binding = RecyclerCellTourBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return TourViewHolder(binding = binding, parent.context, onCellClicked = onCellClicked)
            }
        }
    }
}
