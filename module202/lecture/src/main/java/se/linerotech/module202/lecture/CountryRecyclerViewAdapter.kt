package se.linerotech.module202.lecture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import se.linerotech.module202.lecture.databinding.LayoutCellBinding

class CountryRecyclerViewAdapter(
    private val countries: List<Country>,
    private val onCountryClickListener: (Country) -> Unit
) : RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder.create(parent, onCountryClickListener)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(
        private val binding: LayoutCellBinding,
        private val onCountryClickListener: (Country) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.textViewCountryName.text = country.countryName
            binding.root.setOnClickListener { onCountryClickListener(country) }

            Glide
                .with(binding.imageViewFlag)
                .load(country.flagUrl)
                .centerCrop()
                .into(binding.imageViewFlag)
        }

        companion object {
            fun create(parent: ViewGroup, onCountryClickListener: (Country) -> Unit): CountryViewHolder {
                val binding = LayoutCellBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CountryViewHolder(
                    binding = binding,
                    onCountryClickListener = onCountryClickListener
                )
            }
        }
    }
}
