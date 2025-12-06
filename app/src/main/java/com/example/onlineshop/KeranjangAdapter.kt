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

class KeranjangAdapter(
    private val items: MutableList<Product>,
    private val listener: CartListener
) : RecyclerView.Adapter<KeranjangAdapter.KeranjangViewHolder>() {

    interface CartListener {
        fun onCartChanged() // dipanggil setiap ada perubahan (quantity / checked / remove)
    }

    inner class KeranjangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduk: ImageView = itemView.findViewById(R.id.imgProduk)
        val txtBrand: TextView = itemView.findViewById(R.id.txtBrand)
        val txtNama: TextView = itemView.findViewById(R.id.txtNamaProduk)
        val txtHarga: TextView = itemView.findViewById(R.id.txtHarga)
        val cbPilih: CheckBox = itemView.findViewById(R.id.cbPilih)
        val btnMinus: ImageView = itemView.findViewById(R.id.btnMinus)
        val btnPlus: ImageView = itemView.findViewById(R.id.btnPlus)
        val txtJumlah: TextView = itemView.findViewById(R.id.txtJumlah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeranjangViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keranjang, parent, false)
        return KeranjangViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: KeranjangViewHolder, position: Int) {
        val product = items[position]

        holder.imgProduk.setImageResource(product.imageUrl)
        holder.txtBrand.text = product.brand
        holder.txtNama.text = product.name

        val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        holder.txtHarga.text = format.format(product.price.toDouble())

        // hindari callback listener saat kita programmatically setChecked
        holder.cbPilih.setOnCheckedChangeListener(null)
        holder.cbPilih.isChecked = product.isChecked
        holder.cbPilih.setOnCheckedChangeListener { _, isChecked ->
            product.isChecked = isChecked
            listener.onCartChanged()
        }

        holder.txtJumlah.text = product.quantity.toString()

        holder.btnPlus.setOnClickListener {
            product.quantity += 1
            holder.txtJumlah.text = product.quantity.toString()
            // update harga display (jika ingin menampilkan subtotal per item, bisa ditambahkan)
            listener.onCartChanged()
        }

        holder.btnMinus.setOnClickListener {
            if (product.quantity > 1) {
                product.quantity -= 1
                holder.txtJumlah.text = product.quantity.toString()
                listener.onCartChanged()
            }
        }

        // (Opsional) jika mau menghapus item saat checkbox di-uncheck dan quantity = 0, dsb.
        // Untuk saat ini kita hanya update quantity / checked.
    }

    /** Memungkinkan fragment memperbarui seluruh list jika diperlukan */
    fun updateList(newList: List<Product>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}
