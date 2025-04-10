package se.linerotech.module203.guide.tours

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        private val onCellClicked: (Tour) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tour: Tour) {
            binding.title.text = tour.name
            binding.cost.text = "${tour.cost}"
            binding.days.text = "${tour.days}"
            binding.location.text = tour.location
            binding.tourCard.setOnClickListener { onCellClicked(tour) }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: (Tour) -> Unit): TourViewHolder {
                val binding = RecyclerCellTourBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return TourViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
