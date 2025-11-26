package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Fragment untuk menu Notifikasi
class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Ganti dengan layout fragment_notifications.xml Anda
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }
}