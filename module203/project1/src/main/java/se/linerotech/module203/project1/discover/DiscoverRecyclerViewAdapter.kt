package se.linerotech.module203.project1.discover

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.databinding.RecyclerCellDiscoverBinding

class DiscoverRecyclerViewAdapter(
    private val items: List<Discover>,
    private val onCellClicked: (Discover) -> Unit,
) : RecyclerView.Adapter<DiscoverRecyclerViewAdapter.DiscoverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
        return DiscoverViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DiscoverViewHolder(
        private val binding: RecyclerCellDiscoverBinding,
        private val context: Context,
        private val onCellClicked: (Discover) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(discover: Discover) {
            binding.root.setOnClickListener {
                onCellClicked(discover)
            }
            binding.textViewTitle.text = discover.title
            binding.textViewAuthor.text = discover.author
            binding.textViewAverageRating.text = discover.averageRating.toString()
            binding.textViewRatingCount.text = context.getString(R.string.ratings, discover.ratingCount)
            binding.discoverCard.setOnClickListener { onCellClicked(discover) }
            loadImage(discover.image)
        }

        private fun loadImage(url: String) {
            Glide
                .with(binding.imageView)
                .load(url)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(CORNER_RADIUS)))
                .into(binding.imageView)
        }

        companion object {
            const val CORNER_RADIUS = 10
            fun create(parent: ViewGroup, onCellClicked: (Discover) -> Unit): DiscoverViewHolder {
                val binding = RecyclerCellDiscoverBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return DiscoverViewHolder(binding = binding, parent.context, onCellClicked = onCellClicked)
            }
        }
    }
}
