package com.example.onlineshop

import android.content.Intent
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

            // Meneruskan fungsi navigateToProductDescription ke adapter
        val productAdapter = ProductAdapter(productList) { product ->
                navigateToProductDescription(product) // <-- Panggil fungsi baru
            }

            productsRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        productsRecyclerView.adapter = productAdapter

        }

    private fun navigateToProductDescription(product: Product) {
        val intent = Intent(requireActivity(), OrderActivity::class.java).apply {
            putExtra("product_detail", product)
        }
        startActivity(intent)
    }



    }


    /**
     * Fungsi untuk menangani navigasi ke DeskripsiFragment dan mengirim objek Product.
     * @param product Produk yang akan ditampilkan deskripsinya.
     */






