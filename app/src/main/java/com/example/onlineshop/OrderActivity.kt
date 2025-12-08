package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        if (savedInstanceState == null) {

            // 1. Cek apakah Intent membawa data LIST produk untuk CHECKOUT (dari KeranjangFragment)
            val checkoutItems: ArrayList<Product>? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                // Mencoba mengambil List produk menggunakan kunci "checkout_item"
                intent.getParcelableArrayListExtra("checkout_item", Product::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableArrayListExtra("checkout_item")
            }

            if (!checkoutItems.isNullOrEmpty()) {
                // --- KASUS 1: Navigasi dari KeranjangFragment (Checkout) ---

                val checkoutFragment = CheckoutFragment().apply {
                    arguments = Bundle().apply {
                        // Masukkan data list produk ke Arguments Fragment
                        putParcelableArrayList("checkout_item", checkoutItems)
                    }
                }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.order_fragment_container, checkoutFragment)
                    .commit()

            } else {
                // --- KASUS 2: Logika yang Sudah Ada (Deskripsi dari HomeFragment) ---

                // 1. Ambil data produk tunggal dari Intent
                val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    // Menggunakan kunci yang sudah ada (HomeFragment.KEY_PRODUCT_DETAIL)
                    intent.getParcelableExtra(HomeFragment.KEY_PRODUCT_DETAIL, Product::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra<Product>(HomeFragment.KEY_PRODUCT_DETAIL)
                }

                // 2. Periksa apakah produk tunggal berhasil diterima
                if (product != null) {
                    // 3. Muat DeskripsiFragment
                    val deskripsiFragment = DeskripsiFragment.newInstance(product)

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.order_fragment_container, deskripsiFragment)
                        .commit()
                } else {
                    // 4. Jika tidak ada data yang berhasil diterima sama sekali (Checkout ATAU Deskripsi)
                    Toast.makeText(this, "Error: Gagal menerima data produk untuk ditampilkan.", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}