package se.linerotech.module203.guide.flights

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module203.guide.R
import se.linerotech.module203.guide.databinding.RecyclerCellFlightBinding

class FlightRecyclerViewAdapter(
    private val items: List<Flight>,
    private val onCellClicked: (Flight) -> Unit,
) : RecyclerView.Adapter<FlightRecyclerViewAdapter.FlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FlightViewHolder(
        private val binding: RecyclerCellFlightBinding,
        private val context: Context,
        private val onCellClicked: (Flight) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(flight: Flight) {
            binding.airportFrom.text = flight.from
            binding.airportTo.text = flight.to
            binding.duration.text = context.resources.getQuantityString(
                R.plurals.hours,
                flight.durationInHours,
                flight.durationInHours
            )
            binding.departure.text = flight.departure
            binding.arrival.text = flight.arrival
            binding.flightPrice.text = context.getString(R.string.sek, flight.price.toInt())
            if (flight.stops == 0) {
                binding.stops.text = context.getString(R.string.non_stop)
            } else {
                binding.stops.text = context.resources.getQuantityString(R.plurals.stops, flight.stops, flight.stops)
            }
            binding.flightCard.setOnClickListener { onCellClicked(flight) }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: (Flight) -> Unit): FlightViewHolder {
                val binding = RecyclerCellFlightBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return FlightViewHolder(binding = binding, parent.context, onCellClicked = onCellClicked)
            }
        }
    }
}
