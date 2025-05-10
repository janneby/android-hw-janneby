package se.linerotech.module203.project2.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module203.project2.databinding.RecyclerCellAboutBinding

class AboutRecyclerViewAdapter(
    private val items: List<About>,
    private val onCellClicked: (About) -> Unit
) : RecyclerView.Adapter<AboutRecyclerViewAdapter.AboutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        return AboutViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        val about = items[position]
        holder.bind(about)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AboutViewHolder(
        private val binding: RecyclerCellAboutBinding,
        private val onCellClicked: (About) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: About) {
            binding.textViewTitle.setText(category.title)
            binding.textViewDescription.setText(category.description)
            binding.aboutCard.setOnClickListener { onCellClicked(category) }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: (About) -> Unit): AboutViewHolder {
                val binding = RecyclerCellAboutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return AboutViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
