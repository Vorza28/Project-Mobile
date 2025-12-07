package com.example.onlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.Product

class ProductAdapter(
    private var filteredList: List<Product>,    // <-- sekarang list bisa berubah
    private val clickListener: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ==== FUNGSI BARU UNTUK UPDATE LIST PRODUK ====
    fun updateData(newList: List<Product>) {
        filteredList = newList
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.product_image)
        val brandTextView: TextView = itemView.findViewById(R.id.product_brand)
        val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)

        fun bind(product: Product, clickListener: (Product) -> Unit) {
            imageView.setImageResource(product.imageUrl)
            brandTextView.text = product.brand
            nameTextView.text = product.name

            val formattedPrice = String.format("Rp %,d", product.price).replace(",", ".")
            priceTextView.text = formattedPrice

            itemView.setOnClickListener {
                clickListener(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_grid, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(filteredList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }
}
