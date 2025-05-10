package se.linerotech.module203.project2.incidents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module203.project2.databinding.RecyclerCellIncidentBinding

class IncidentsRecyclerViewAdapter(
    private val items: List<Incident>,
    private val onCellClicked: (Incident) -> Unit,
) : RecyclerView.Adapter<IncidentsRecyclerViewAdapter.IncidentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentsViewHolder {
        return IncidentsViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: IncidentsViewHolder, position: Int) {
        val repositories = items[position]
        holder.bind(repositories)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class IncidentsViewHolder(
        private val binding: RecyclerCellIncidentBinding,
        private val onCellClicked: (Incident) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(incident: Incident) {
            binding.textViewTitle.text = incident.type
            binding.textViewLocation.text = incident.location?.name ?: ""
            binding.textViewDate.text = incident.datetime
            binding.textViewDescription.text = incident.summary
            binding.root.setOnClickListener { onCellClicked(incident) }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onCellClicked: (Incident) -> Unit
            ): IncidentsViewHolder {
                val binding = RecyclerCellIncidentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return IncidentsViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
