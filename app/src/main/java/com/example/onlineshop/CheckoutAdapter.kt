package com.example.onlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CheckoutAdapter(
    private val items: List<Product>
) : RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageProduk: ImageView = itemView.findViewById(R.id.imageProduk)
        val textBrand: TextView = itemView.findViewById(R.id.textBrand)
        val textNamaProduk: TextView = itemView.findViewById(R.id.textNamaProduk)
        val textJumlah: TextView = itemView.findViewById(R.id.textJumlah)
        val textHarga: TextView = itemView.findViewById(R.id.textHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_checkout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = items[position]

        // Gambar
        holder.imageProduk.setImageResource(produk.imageUrl)

        // Teks
        holder.textBrand.text = produk.brand
        holder.textNamaProduk.text = produk.name
        holder.textJumlah.text = "Jumlah : ${produk.quantity}"

        // Format harga ke Rupiah
        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        holder.textHarga.text = formatRupiah.format(produk.price.toDouble())
    }

    override fun getItemCount(): Int = items.size
}
