package com.example.onlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CheckoutAdapter(private val items: List<Product>) :
    RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_checkout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.imageProduk)
        private val brand: TextView = itemView.findViewById(R.id.textBrand)
        private val nama: TextView = itemView.findViewById(R.id.textNamaProduk)
        private val jumlah: TextView = itemView.findViewById(R.id.textJumlah)
        private val harga: TextView = itemView.findViewById(R.id.textHarga)

        fun bind(product: Product) {
            image.setImageResource(product.imageUrl)
            brand.text = product.brand
            nama.text = product.name
            jumlah.text = "Jumlah : 1"

            val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
            harga.text = formatRupiah.format(product.price.toDouble())
        }
    }
}
