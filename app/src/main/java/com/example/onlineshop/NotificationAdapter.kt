package com.example.onlineshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

class NotificationAdapter(
    private val items: List<NotificationItem>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.notification_icon)
        val title: TextView = itemView.findViewById(R.id.notification_title)
        val time: TextView = itemView.findViewById(R.id.notification_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return NotificationViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val item = items[position]

        holder.title.text = item.title

        // Format Waktu
        val dateFormat = SimpleDateFormat("dd MMM, HH:mm", Locale("in", "ID"))
        holder.time.text = dateFormat.format(item.timestamp)

        // Atur Ikon berdasarkan Tipe Notifikasi
        when (item.type) {
            NotificationType.ORDER_SUCCESS -> holder.icon.setImageResource(R.drawable.ic_check_circle)
            NotificationType.INFO -> holder.icon.setImageResource(android.R.drawable.ic_menu_info_details)
        }
    }
}