package com.example.onlineshop

import CategoryAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    companion object {
        const val KEY_PRODUCT_DETAIL = "product_detail"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // === RecyclerView Product ===
        val recyclerView = view.findViewById<RecyclerView>(R.id.products_grid_recycler_view)
        val productList = Product.getDummyProducts()

        val productAdapter = ProductAdapter(productList) { product ->
            launchOrderActivity(product)
        }

        recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = productAdapter
        }

        // === RecyclerView Category ===
        val recyclerViewCategory = view.findViewById<RecyclerView>(R.id.category_recycler_view)
        val categoryList = getDummyCategory()

        val categoryAdapter = CategoryAdapter(categoryList) { category ->
            // Klik kategori (opsional)
        }

        recyclerViewCategory.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }

    private fun launchOrderActivity(product: Product) {
        val intent = Intent(requireActivity(), OrderActivity::class.java).apply {
            putExtra(KEY_PRODUCT_DETAIL, product)
        }
        startActivity(intent)
    }

    // === LIST KATEGORI (TIDAK MENGUBAH FUNGSI LAIN) ===
    private fun getDummyCategory(): List<Category> {
        return listOf(
            Category("Kaos", R.drawable.kaos),
            Category("Celana", R.drawable.celana),
            Category("Jaket", R.drawable.jaket),
            Category("Sepatu", R.drawable.sepatu)
        )
    }
}
