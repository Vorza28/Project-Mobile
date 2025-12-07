package com.example.onlineshop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Impor Product dan ProductAdapter diperlukan untuk fungsionalitas
import com.example.onlineshop.Product
import com.example.onlineshop.ProductAdapter

/**
 * HomeFragment bertanggung jawab untuk menampilkan halaman utama aplikasi,
 * termasuk daftar produk yang direkomendasikan.
 */
class HomeFragment : Fragment() {

    // Companion object untuk menyimpan konstanta, seperti kunci untuk Intent.
    // Ini adalah praktik yang baik untuk menghindari kesalahan pengetikan.
    companion object {
        const val KEY_PRODUCT_DETAIL = "product_detail"
    }

    /**
     * Metode ini dipanggil untuk membuat View untuk fragment.
     * Di sini, kita menghubungkan layout XML (fragment_home.xml) dengan fragment ini.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menggunakan inflater untuk mengubah file layout XML menjadi objek View.
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * Metode ini dipanggil setelah View dari onCreateView() selesai dibuat.
     * Semua logika yang berhubungan dengan setup View (seperti RecyclerView) dilakukan di sini.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Temukan RecyclerView dari layout menggunakan ID-nya.
        val recyclerView = view.findViewById<RecyclerView>(R.id.products_grid_recycler_view)

        // 1. Dapatkan daftar produk (dalam kasus ini, data dummy).
        // Di aplikasi nyata, ini bisa berasal dari database atau API.
        val productList = Product.getDummyProducts()

        // 2. Siapkan Adapter dengan daftar produk dan logika klik.
        // Lambda ' { product -> launchOrderActivity(product) } ' akan dieksekusi
        // setiap kali sebuah item di dalam adapter diklik.
        val productAdapter = ProductAdapter(productList) { product ->
            launchOrderActivity(product)
        }

        // 3. Konfigurasi RecyclerView.
        recyclerView.apply {
            // Mengatur LayoutManager menjadi GridLayout dengan 2 kolom.
            layoutManager = GridLayoutManager(requireContext(), 2)
            // Menetapkan adapter yang sudah kita buat ke RecyclerView.
            adapter = productAdapter
        }
    }

    /**
     * Fungsi privat untuk membuat Intent dan memulai OrderActivity.
     * Fungsi ini membawa data produk yang dipilih.
     * @param product Objek Produk yang akan dikirim ke OrderActivity.
     */
    private fun launchOrderActivity(product: Product) {
        // Membuat Intent yang menargetkan OrderActivity.
        val intent = Intent(requireActivity(), OrderActivity::class.java).apply {
            // Menambahkan data 'product' (yang harus Parcelable) ke dalam Intent
            // menggunakan kunci yang telah kita definisikan di companion object.
            putExtra(KEY_PRODUCT_DETAIL, product)
        }
        // Memulai activity baru.
        startActivity(intent)
    }

    // === LIST KATEGORI (TIDAK MENGUBAH FUNGSI LAIN) ===
    private fun getDummyCategory(): List<Category> {
        return listOf(
            Category("Kaos", R.drawable.kaos),
            Category("Celana", R.drawable.celana),
            Category("Jaket", R.drawable.jaket),
            Category("Sepatu", R.drawable.sepatu),
            Category("Topi", R.drawable.topi)
        )
    }
}
