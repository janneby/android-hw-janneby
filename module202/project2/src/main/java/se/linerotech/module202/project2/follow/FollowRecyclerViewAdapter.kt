package se.linerotech.module202.project2.follow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import se.linerotech.module202.project2.R
import se.linerotech.module202.project2.databinding.LayoutCellFollowBinding

class FollowRecyclerViewAdapter(
    private val items: List<Follow>,
    private val onCellClicked: (Follow) -> Unit
) : RecyclerView.Adapter<FollowRecyclerViewAdapter.FollowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowViewHolder {
        return FollowViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: FollowViewHolder, position: Int) {
        val follower = items[position]
        holder.bind(follower)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FollowViewHolder(
        private val binding: LayoutCellFollowBinding,
        private val onCellClicked: (Follow) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(follow: Follow) {
            binding.textViewUserName.text = follow.login
            Glide.with(binding.root.context)
                .load(follow.avatarUrl)
                .circleCrop()
                .placeholder(R.drawable.github_logo)
                .into(binding.imageViewUser)
            binding.root.setOnClickListener { onCellClicked(follow) }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onCellClicked: (Follow) -> Unit
            ): FollowViewHolder {
                val binding = LayoutCellFollowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return FollowViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
