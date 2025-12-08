package com.example.onlineshop

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R

class CategoryAdapter(
    private val list: List<Category>,
    private val onClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    // Posisi kategori yang dipilih (default: posisi 0 → "Tampilkan Semua")
    private var selectedPosition = 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.category_image)
        val title: TextView = view.findViewById(R.id.category_title)
        val container: View = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = list[position]

        // Set icon & title
        holder.icon.setImageResource(category.icon)
        holder.title.text = category.name

        // Highlight effect
        holder.container.alpha = if (selectedPosition == position) 1f else 0.5f

        // OnClick item kategori
        holder.itemView.setOnClickListener {
            val previous = selectedPosition
            selectedPosition = position

            // Refresh item sebelumnya + item saat ini
            notifyItemChanged(previous)
            notifyItemChanged(selectedPosition)

            // Callback ke HomeFragment
            onClick(category)
        }
    }

    override fun getItemCount(): Int = list.size
}
