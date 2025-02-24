package se.linerotech.module202.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.guide.databinding.LayoutCellCategoryBinding

class CategoryRecylerViewAdapter(
    val items: List<Category>
) : RecyclerView.Adapter<CategoryRecylerViewAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = items[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CategoryViewHolder(private val binding: LayoutCellCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.categoryName.text = category.name
            binding.cardView.setBackgroundResource(category.image)
        }

        companion object {
            fun create(parent: ViewGroup): CategoryViewHolder {
                val binding = LayoutCellCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CategoryViewHolder(binding)
            }
        }
    }
}
