package se.linerotech.module202.project1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.project1.databinding.LayoutCellCityBinding

class CityRecyclerViewAdapter(
    private val items: List<City>,
    private val onCellClicked: (City) -> Unit,
) : RecyclerView.Adapter<CityRecyclerViewAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val cityName = items[position]
        holder.bind(cityName)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CityViewHolder(
        private val binding: LayoutCellCityBinding,
        private val onCellClicked: (City) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(city: City) {
            binding.imageViewCityCell.setBackgroundResource(city.cityImage)
            binding.imageViewCityCell.setOnClickListener { onCellClicked(city) }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: (City) -> Unit): CityViewHolder {
                val binding = LayoutCellCityBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CityViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
