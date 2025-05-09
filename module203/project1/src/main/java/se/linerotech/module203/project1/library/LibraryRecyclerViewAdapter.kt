package se.linerotech.module203.project1.library

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import se.linerotech.module203.project1.R
import se.linerotech.module203.project1.databinding.RecyclerCellLibraryBinding

class LibraryRecyclerViewAdapter(
    private val items: List<Library>,
    private val onCellClicked: (Library) -> Unit,
) : RecyclerView.Adapter<LibraryRecyclerViewAdapter.LibraryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        return LibraryViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class LibraryViewHolder(
        private val binding: RecyclerCellLibraryBinding,
        private val context: Context,
        private val onCellClicked: (Library) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(library: Library) {
            binding.textViewCategory.text = library.categoryName
            binding.textViewCategoryBookAmount.text = context.getString(R.string.books, library.bookList.size)

//            binding.tourCard.setOnClickListener { onCellClicked(tour) }
            if (library.bookList.isNotEmpty() && !library.bookList[0].image.isNullOrEmpty()) {
                loadImage(library.bookList[0].image.toString())
            } else {
                binding.imageViewCategory.setImageResource(R.drawable.no_cover)
            }
        }

        private fun loadImage(url: String) {
            Glide
                .with(binding.imageViewCategory)
                .load(url)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(CORNER_RADIUS)))
                .into(binding.imageViewCategory)
        }

        companion object {
            const val CORNER_RADIUS = 10
            fun create(parent: ViewGroup, onCellClicked: (Library) -> Unit): LibraryViewHolder {
                val binding = RecyclerCellLibraryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return LibraryViewHolder(binding = binding, parent.context, onCellClicked = onCellClicked)
            }
        }
    }
}
