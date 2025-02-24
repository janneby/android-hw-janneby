package se.linerotech.module202.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module202.guide.databinding.LayoutCellCategoryBinding

class CategoryRecylerViewAdapter(
    val items: List<Category>
) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            LayoutCellCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = items[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
