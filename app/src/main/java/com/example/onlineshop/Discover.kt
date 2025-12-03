package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.ProductAdapter
import com.example.onlineshop.Product

class DiscoverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Asumsi menggunakan layout fragment_discover.xml
        // Jika Anda menggunakan layout yang sama dengan HomeFragment, ganti R.layout.fragment_discover
        // dengan ID layout yang benar. Kami asumsikan ada layout fragment_discover.xml
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Inisialisasi RecyclerView Produk Grid ---

        // 1. Ambil data dummy dari Product.kt (bisa menggunakan data yang sama)
        val productList = Product.getDummyProducts()

        // 2. Cari RecyclerView menggunakan ID yang sama dengan HomeFragment atau ID spesifik Discover
        // Asumsi menggunakan ID products_grid_recycler_view seperti di HomeFragment
        val productsRecyclerView = view.findViewById<RecyclerView>(R.id.discover_products_grid_recycler_view)

        // 3. Pastikan RecyclerView ditemukan
        if (productsRecyclerView != null) {

            // 4. Set LayoutManager jika belum diset
            if (productsRecyclerView.layoutManager == null) {
                // Menggunakan GridLayoutManager dengan 2 kolom
                productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
            }

            // 5. Inisialisasi Adapter dengan data dan listener klik
            val productAdapter = ProductAdapter(productList) { product ->

            // Callback untuk navigasi ke DeskripsiFragment
                // TODO: Implementasikan navigasi ke DeskripsiFragment di sini,
                // Sama seperti di HomeFragment.
                // Contoh: navigateToProductDescription(product)
            }

            // 6. Pasang Adapter ke RecyclerView
            productsRecyclerView.adapter = productAdapter
        }
        // --- End of RecyclerView Produk Grid Setup ---
    }
}