package se.linerotech.module203.project2.stations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module203.project2.databinding.RecyclerCellStationBinding

class StationsRecyclerViewAdapter(
    private val items: List<Station>,
    private val onCellClicked: (Station) -> Unit,
) : RecyclerView.Adapter<StationsRecyclerViewAdapter.StationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationsViewHolder {
        return StationsViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: StationsViewHolder, position: Int) {
        val repositories = items[position]
        holder.bind(repositories)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StationsViewHolder(
        private val binding: RecyclerCellStationBinding,
        private val onCellClicked: (Station) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(station: Station) {
            binding.textViewTitle.text = station.name
            binding.textViewLocation.text = station.location.name

            val serviceList = station.services
            var services = ""

            for ((index, service) in serviceList.withIndex()) {
                if (index != station.services.size - 1) {
                    services = services + service.name + ","
                } else {
                    services = services + service.name + "."
                }
            }

            binding.textViewServices.text = services

            binding.root.setOnClickListener { onCellClicked(station) }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onCellClicked: (Station) -> Unit
            ): StationsViewHolder {
                val binding = RecyclerCellStationBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return StationsViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
