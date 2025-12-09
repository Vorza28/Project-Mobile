package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Fragment untuk menu Notifikasi
class NotificationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var headerTitle: TextView
    private lateinit var emptyTextView: TextView // Tambahan untuk teks kosong
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Pastikan layout XML yang sudah diperbaiki digunakan
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_notifications)
        headerTitle = view.findViewById(R.id.header_title)
        emptyTextView = view.findViewById(R.id.tv_empty_notification)

        // Setup RecyclerView
        notificationAdapter = NotificationAdapter(listOf()) // Inisialisasi dengan list kosong
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = notificationAdapter
        }

        loadNotifications()
    }

    override fun onResume() {
        super.onResume()
        // Muat ulang data setiap kali fragment ditampilkan
        loadNotifications()
    }

    private fun loadNotifications() {
        val notifications = NotificationManager.getNotifications()

        // Perbarui data adapter
        notificationAdapter = NotificationAdapter(notifications)
        recyclerView.adapter = notificationAdapter

        updateUI(notifications.size)
    }

    private fun updateUI(count: Int) {
        if (count > 0) {
            headerTitle.text = "Notifikasi ($count total)"
            recyclerView.visibility = View.VISIBLE
            emptyTextView.visibility = View.GONE
        } else {
            headerTitle.text = "Notifikasi (0)"
            recyclerView.visibility = View.GONE
            emptyTextView.visibility = View.VISIBLE
        }
    }
}