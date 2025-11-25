package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Fragment untuk menu penemuan/pencarian (Discover)
class DiscoverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Ganti dengan layout fragment_discover.xml Anda
        // Karena Anda belum membuat layout ini, Anda bisa menggunakan placeholder
        // atau membuat file XML sederhana.
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }
}