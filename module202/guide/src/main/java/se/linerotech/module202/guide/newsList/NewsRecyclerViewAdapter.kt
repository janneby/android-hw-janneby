package se.linerotech.module202.guide.newsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.guide.common.News
import se.linerotech.module202.guide.databinding.LayoutCellNewsBinding

class NewsRecyclerViewAdapter(
    private val items: List<News>,
    private val onCellClicked: () -> Unit,
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
        private val onCellClicked: () -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            binding.textViewSource.text = news.source
            binding.textViewDate.text = news.date
            binding.textViewTitle.text = news.title
            binding.root.setOnClickListener { onCellClicked() }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: () -> Unit): NewsViewHolder {
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
