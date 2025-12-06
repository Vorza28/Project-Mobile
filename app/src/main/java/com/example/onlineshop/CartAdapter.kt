package com.example.onlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CartAdapter(
    private val cartList: MutableList<Product>,
    private val listener: CartListener
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    interface CartListener {
        fun onQuantityChanged()
        fun onItemChecked()
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgProduk)
        val txtBrand: TextView = itemView.findViewById(R.id.txtBrand)
        val txtNama: TextView = itemView.findViewById(R.id.txtNamaProduk)
        val txtHarga: TextView = itemView.findViewById(R.id.txtHarga)
        val cb: CheckBox = itemView.findViewById(R.id.cbPilih)

        val btnMinus: ImageView = itemView.findViewById(R.id.btnMinus)
        val btnPlus: ImageView = itemView.findViewById(R.id.btnPlus)
        val txtJumlah: TextView = itemView.findViewById(R.id.txtJumlah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_keranjang, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = cartList.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartList[position]

        holder.img.setImageResource(item.imageUrl)
        holder.txtBrand.text = item.brand
        holder.txtNama.text = item.name

        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        holder.txtHarga.text = formatRupiah.format(item.price.toDouble())

        holder.txtJumlah.text = item.quantity.toString()
        holder.cb.isChecked = item.isChecked

        // Checkbox
        holder.cb.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
            listener.onItemChecked()
        }

        // + BUTTON
        holder.btnPlus.setOnClickListener {
            item.quantity++
            holder.txtJumlah.text = item.quantity.toString()
            listener.onQuantityChanged()
        }

        // - BUTTON
        holder.btnMinus.setOnClickListener {
            if (item.quantity > 1) {
                item.quantity--
                holder.txtJumlah.text = item.quantity.toString()
                listener.onQuantityChanged()
            }
        }
    }
}
