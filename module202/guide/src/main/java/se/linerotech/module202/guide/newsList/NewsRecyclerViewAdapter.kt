package se.linerotech.module202.guide.newsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import se.linerotech.module202.guide.R
import se.linerotech.module202.guide.common.News
import se.linerotech.module202.guide.databinding.LayoutCellNewsBinding

class NewsRecyclerViewAdapter(
    private val items: List<News>,
    private val onCellClicked: (News) -> Unit,
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = items[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NewsViewHolder(
        private val binding: LayoutCellNewsBinding,
        private val onCellClicked: (News) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            binding.textViewSource.text = news.source
            binding.textViewDate.text = news.date
            binding.textViewTitle.text = news.title
            binding.root.setOnClickListener { onCellClicked(news) }
            loadImage(url = news.image)
        }

        private fun loadImage(url: String) {
            if (url.isEmpty()) {
                binding.image.setImageResource(R.drawable.general_image)
            } else {
                Glide
                    .with(binding.image)
                    .load(url)
                    .placeholder(R.drawable.general_image)
                    .centerCrop()
                    .into(binding.image)
            }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: (News) -> Unit): NewsViewHolder {
                val binding = LayoutCellNewsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NewsViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
