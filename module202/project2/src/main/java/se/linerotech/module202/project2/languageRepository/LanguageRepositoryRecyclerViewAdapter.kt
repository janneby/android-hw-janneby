package se.linerotech.module202.project2.languageRepository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.project2.databinding.LayoutCellRepositoryBinding

class LanguageRepositoryRecyclerViewAdapter(
    private val items: List<LanguageRepository>,
    private val onCellClicked: (LanguageRepository) -> Unit,
) : RecyclerView.Adapter<LanguageRepositoryRecyclerViewAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repositories = items[position]
        holder.bind(repositories)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RepositoryViewHolder(
        private val binding: LayoutCellRepositoryBinding,
        private val onCellClicked: (LanguageRepository) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(languageRepository: LanguageRepository) {
            binding.textViewTitle.text = languageRepository.title
            binding.textViewDescription.text = languageRepository.description
            binding.textViewLanguage.text = languageRepository.language
            binding.textViewDate.text = languageRepository.date
            binding.textViewLicense.text = languageRepository.license
            binding.root.setOnClickListener { onCellClicked(languageRepository) }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onCellClicked: (LanguageRepository) -> Unit
            ): RepositoryViewHolder {
                val binding = LayoutCellRepositoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RepositoryViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
