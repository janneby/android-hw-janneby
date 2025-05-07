package se.linerotech.module202.project2.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.project2.databinding.LayoutCellRepositoryBinding

class UserRepositoryRecyclerViewAdapter(
    private val items: List<UserRepository>,
    private val onCellClicked: (UserRepository) -> Unit,
) : RecyclerView.Adapter<UserRepositoryRecyclerViewAdapter.RepositoryViewHolder>() {

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
        private val onCellClicked: (UserRepository) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userRepository: UserRepository) {
            binding.textViewTitle.text = userRepository.login
//            binding.textViewDescription.text = languageRepository.description
//            binding.textViewLanguage.text = languageRepository.language
//            binding.textViewDate.text = languageRepository.date
//            binding.textViewLicense.text = languageRepository.license
//            binding.root.setOnClickListener { onCellClicked(userRepository) }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onCellClicked: (UserRepository) -> Unit
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
