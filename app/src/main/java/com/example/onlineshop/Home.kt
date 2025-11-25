package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Fragment untuk menu utama (Home)
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Ganti dengan layout fragment_home.xml Anda
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Tambahkan logika utama (load data, set adapter RecyclerView, dll.) di onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Contoh: Logika untuk menampilkan daftar produk dan kategori
    }
}