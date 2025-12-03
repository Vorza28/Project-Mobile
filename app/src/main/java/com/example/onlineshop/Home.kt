package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Fragment untuk menu utama (Home)
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menggunakan layout fragment_home.xml
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Inisialisasi RecyclerView Produk Grid ---

        // 1. Ambil data dummy dari Product.kt
        val productList = Product.getDummyProducts()

        // 2. Cari RecyclerView menggunakan ID dari XML: products_grid_recycler_view
        val productsRecyclerView = view.findViewById<RecyclerView>(R.id.products_grid_recycler_view)

        // 3. (Opsional, tapi aman) Pastikan LayoutManager sudah diset.
        // Berdasarkan XML Anda, ini sudah diset sebagai GridLayoutManager (spanCount=2).
        // Baris ini hanya sebagai fallback jika XML belum sepenuhnya diimplementasikan.
        if (productsRecyclerView.layoutManager == null) {
            productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
        }

        // 4. Inisialisasi Adapter dengan data dan listener klik
        // Catatan: clickListener adalah lambda kosong sementara,
        // Anda harus mengisinya dengan logika navigasi ke DeskripsiFragment.
        val productAdapter = ProductAdapter(productList) { product ->
            // TODO: Implementasikan navigasi ke DeskripsiFragment di sini.
            // Contoh navigasi: navigateToProductDescription(product)
        }

        // 5. Pasang Adapter ke RecyclerView
        productsRecyclerView.adapter = productAdapter

        // --- End of RecyclerView Produk Grid Setup ---

        // TODO: Anda mungkin perlu menginisialisasi category_recycler_view di sini juga.
    }

}