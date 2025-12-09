package com.example.onlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private var originalList: List<Product>,
    private val clickListener: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var filteredList: MutableList<Product> = originalList.toMutableList()

    // ==== UPDATE DATA (untuk kategori) ====
    fun updateData(newList: List<Product>) {
        originalList = newList
        filteredList = newList.toMutableList()
        notifyDataSetChanged()
    }

    // ==== FILTER SEARCH ====
    fun filter(query: String) {
        val keyword = query.lowercase()

        filteredList = if (keyword.isEmpty()) {
            originalList.toMutableList()
        } else {
            originalList.filter {
                it.name.lowercase().contains(keyword) ||
                        it.brand.lowercase().contains(keyword) ||
                        it.kategori.name.lowercase().contains(keyword)
            }.toMutableList()
        }

        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.product_image)
        private val brandTextView: TextView = itemView.findViewById(R.id.product_brand)
        private val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        private val priceTextView: TextView = itemView.findViewById(R.id.product_price)

        fun bind(product: Product) {
            imageView.setImageResource(product.imageUrl)
            brandTextView.text = product.brand
            nameTextView.text = product.name

            val formattedPrice = String.format("Rp %,d", product.price).replace(",", ".")
            priceTextView.text = formattedPrice

            itemView.setOnClickListener { clickListener(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_grid, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

    override fun getItemCount(): Int = filteredList.size
}
