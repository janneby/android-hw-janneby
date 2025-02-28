package se.linerotech.module202.guide.selectCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.guide.common.Category
import se.linerotech.module202.guide.databinding.LayoutCellCategoryBinding

class CategoryRecyclerViewAdapter(
    private val items: List<Category>,
    private val onCellClicked: (Category) -> Unit,
) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = items[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CategoryViewHolder(
        private val binding: LayoutCellCategoryBinding,
        private val onCellClicked: (Category) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.categoryName.setText(category.name)
            binding.cardView.setBackgroundResource(category.image)
            binding.cardView.setOnClickListener { onCellClicked(category) }
        }

        companion object {
            fun create(parent: ViewGroup, onCellClicked: (Category) -> Unit): CategoryViewHolder {
                val binding = LayoutCellCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CategoryViewHolder(binding = binding, onCellClicked = onCellClicked)
            }
        }
    }
}
