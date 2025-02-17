package se.linerotech.module205.project3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import se.linerotech.module205.project3.model.Article

class ArticleAdapter(
    // private val context: Context,
    private val articlesList: List<Article>,
    private val articalClickListener: (Article) -> Unit,
    // private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articlesList[position]
        return holder.bind(article, articalClickListener)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var textTitle = view.findViewById<TextView>(R.id.articleTitle)
        private var rootView = view.findViewById<CardView>(R.id.viewArticle)
        private var articleAuthor = view.findViewById<TextView>(R.id.articleAuthor)
        private var articleSource = view.findViewById<TextView>(R.id.articleSource)
        private var articleImage = view.findViewById<ImageView>(R.id.articleImage)
        private var articlePublishedBy = view.findViewById<TextView>(R.id.articlePublishedBy)

        fun bind(article: Article, articalClickListener: (Article) -> Unit) {
            articleAuthor.text = article.author
            textTitle.text = article.title
            articlePublishedBy.text = article.publishedAt
            articleSource.text = article.source.toString()

            // Load the image using Glide
            Glide.with(itemView)
                .load(article.urlToImage)
                .into(articleImage)

            rootView.setOnClickListener { articalClickListener(article) }
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_article, parent, false)
                return ViewHolder(view)
            }
        }
    }
}
