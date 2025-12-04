package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.NumberFormat
import java.util.Locale

class DeskripsiFragment : Fragment() {

    // Deklarasi View di level kelas agar bisa diakses di seluruh fragment
    private lateinit var productImageView: ImageView
    private lateinit var brandTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var buyButton: Button

    // Properti untuk menampung data produk
    private var product: Product? = null

    companion object {
        // Kunci untuk menyimpan dan mengambil data dari arguments
        private const val ARG_PRODUCT = "product_data"

        /**
         * Factory method untuk membuat instance baru dari fragment ini.
         * Ini adalah cara yang direkomendasikan untuk mengirim data ke fragment.
         * @param product Produk yang akan ditampilkan.
         * @return Instance baru dari DeskripsiFragment.
         */
        fun newInstance(product: Product): DeskripsiFragment {
            val fragment = DeskripsiFragment()
            val args = Bundle().apply {
                putParcelable(ARG_PRODUCT, product)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ambil data dari arguments di sini
        arguments?.let {
            product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable(ARG_PRODUCT, Product::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.getParcelable(ARG_PRODUCT)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menggunakan layout fragment_deskripsi.xml
        return inflater.inflate(R.layout.fragment_deskripsi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi semua View dari layout
        productImageView = view.findViewById(R.id.imageDeskripsi)
        brandTextView = view.findViewById(R.id.textView6)
        nameTextView = view.findViewById(R.id.textViewNamaProduk)
        priceTextView = view.findViewById(R.id.textViewHarga)
        buyButton = view.findViewById(R.id.buttonBayar)

        // 2. Panggil fungsi untuk menampilkan data
        displayProductData()

        // 3. Atur listener untuk tombol
        buyButton.setOnClickListener {
            product?.let {
                navigateToCheckout(it)
            }
        }
    }

    /**
     * Fungsi untuk menampilkan data produk ke UI.
     */
    private fun displayProductData() {
        if (product != null) {
            productImageView.setImageResource(product!!.imageUrl)
            brandTextView.text = product!!.brand
            nameTextView.text = product!!.name

            // Menggunakan NumberFormat untuk format mata uang yang lebih andal
            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            priceTextView.text = formatRupiah.format(product!!.price.toDouble())

            buyButton.isEnabled = true
        } else {
            // Handle jika data gagal dimuat (seharusnya tidak terjadi jika alur benar)
            Toast.makeText(requireContext(), "Error: Gagal memuat data produk.", Toast.LENGTH_SHORT).show()
            buyButton.isEnabled = false
        }
    }

    /**
     * Fungsi untuk navigasi ke CheckoutFragment.
     */
    private fun navigateToCheckout(product: Product) {
        val checkoutFragment = CheckoutFragment()

        val bundle = Bundle().apply {
            // Asumsi CheckoutFragment menunggu kunci "productData"
            putParcelable("productData", product)
        }
        checkoutFragment.arguments = bundle

        // Navigasi menggunakan FragmentManager (internal di dalam OrderActivity)
        parentFragmentManager.beginTransaction()
            .replace(R.id.order_fragment_container, checkoutFragment) // Asumsi ID container
            .addToBackStack(null)
            .commit()
    }
}
