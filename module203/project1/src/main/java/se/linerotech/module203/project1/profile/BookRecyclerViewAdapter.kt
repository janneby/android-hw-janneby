package se.linerotech.module203.project1.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.project1.common.Book
import se.linerotech.module203.project1.databinding.RecyclerCellBookBinding

class BookRecyclerViewAdapter(
    private val items: List<Book>,
    private val onBookClicked: (Book) -> Unit,
) : RecyclerView.Adapter<BookRecyclerViewAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder.create(parent, onBookClicked)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class BookViewHolder(
        private val binding: RecyclerCellBookBinding,
        private val onBookClicked: (Book) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            loadImage(book.image)

            binding.root.setOnClickListener {
                onBookClicked(book)
            }
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
            fun create(parent: ViewGroup, onBookClicked: (Book) -> Unit): BookViewHolder {
                val binding = RecyclerCellBookBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BookViewHolder(binding = binding, onBookClicked = onBookClicked)
            }
        }
    }
}
