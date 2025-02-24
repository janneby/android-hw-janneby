package se.linerotech.module202.guide

import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.guide.databinding.LayoutCellCategoryBinding

class CategoryViewHolder(private val binding: LayoutCellCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category) {
        binding.categoryName.text = category.name
        binding.cardView.setBackgroundResource(category.image)
    }
}
