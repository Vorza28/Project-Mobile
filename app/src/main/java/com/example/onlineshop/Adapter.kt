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
    private val productList: List<Product>,
    private val clickListener: (Product) -> Unit // lambda function untuk callback klik
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder menyimpan referensi ke semua View yang diperlukan untuk satu item daftar.
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.product_image)
        val brandTextView: TextView = itemView.findViewById(R.id.product_brand)
        val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)

        fun bind(product: Product, clickListener: (Product) -> Unit) {
            // 1. Mengatur Gambar Produk
            imageView.setImageResource(product.imageUrl)

            // 2. Mengatur Brand Produk
            brandTextView.text = product.brand

            // 3. Mengatur Nama Produk
            nameTextView.text = product.name

            // 4. Mengatur Harga Produk (Format ke IDR)
            // Menggunakan format Rupiah dengan pemisah ribuan titik
            val formattedPrice = String.format("Rp %,d", product.price).replace(",", ".")
            priceTextView.text = formattedPrice

            // 5. Menambahkan listener klik
            itemView.setOnClickListener {
                clickListener(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Menginflate layout item grid produk (item_product_grid.xml)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_grid, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}