package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // 1. Ambil data produk dari Intent yang dikirim oleh HomeFragment
        val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Gunakan kunci yang sama persis seperti di HomeFragment
            intent.getParcelableExtra(HomeFragment.KEY_PRODUCT_DETAIL, Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Product>(HomeFragment.KEY_PRODUCT_DETAIL)
        }

        // 2. Periksa apakah produk berhasil diterima
        if (product != null) {
            // 3. Jika berhasil, buat instance DeskripsiFragment menggunakan factory method
            //    dan kirimkan data produk ke dalamnya.
            val deskripsiFragment = DeskripsiFragment.newInstance(product)

            // 4. Tampilkan fragment di dalam container
            supportFragmentManager.beginTransaction()
                .replace(R.id.order_fragment_container, deskripsiFragment) // Pastikan ID container ini ada di activity_order.xml
                .commit()
        } else {
            // 5. Jika data produk tidak ditemukan dari Intent, tampilkan error dan tutup activity
            Toast.makeText(this, "Error: Gagal menerima data produk dari halaman utama.", Toast.LENGTH_LONG).show()
            finish() // Tutup activity karena tidak ada data untuk ditampilkan
        }
    }
}
