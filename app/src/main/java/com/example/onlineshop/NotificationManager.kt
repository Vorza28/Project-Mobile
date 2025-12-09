package com.example.onlineshop

object NotificationManager {
    // Menyimpan daftar notifikasi secara mutable
    // Menggunakan mutableListOf agar datanya tetap ada selama aplikasi berjalan
    private val notifications = mutableListOf<NotificationItem>()

    fun addNotification(item: NotificationItem) {
        // Menambahkan notifikasi baru di posisi paling atas (indeks 0)
        notifications.add(0, item)
    }

    fun getNotifications(): List<NotificationItem> {
        return notifications
    }
}