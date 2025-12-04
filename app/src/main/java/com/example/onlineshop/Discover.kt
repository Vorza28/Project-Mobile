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
        // Menggunakan layout fragment_discover.xml
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Inisialisasi RecyclerView Produk Grid ---
        val productList = Product.getDummyProducts()
        val productsRecyclerView = view.findViewById<RecyclerView>(R.id.discover_products_grid_recycler_view)

        if (productsRecyclerView != null) {

            if (productsRecyclerView.layoutManager == null) {
                productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
            }

            // Meneruskan fungsi navigateToProductDescription ke adapter
            val productAdapter = ProductAdapter(productList) { product ->
                navigateToProductDescription(product) // <-- Panggil fungsi baru
            }

            productsRecyclerView.adapter = productAdapter
        }
        // --- End of RecyclerView Produk Grid Setup ---
    }

    /**
     * Fungsi untuk menangani navigasi ke DeskripsiFragment dan mengirim objek Product.
     * @param product Produk yang akan ditampilkan deskripsinya.
     */
    private fun navigateToProductDescription(product: Product) {
        val descriptionFragment = DeskripsiFragment()

        // Buat Bundle untuk mengirim objek Product yang sudah Parcelable
        val bundle = Bundle().apply {
            putParcelable("product_detail", product) // <-- Kirim objek lengkap
        }

        descriptionFragment.arguments = bundle

        // Navigasi menggunakan FragmentManager
        parentFragmentManager.beginTransaction()
            .replace(R.id.deskripsiFragment, descriptionFragment) // Ganti R.id.fragment_container sesuai ID FrameLayout di Activity Anda
            .addToBackStack(null) // Penting agar tombol 'back' bisa kembali ke DiscoverFragment
            .commit()
    }
}