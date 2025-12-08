package com.example.onlineshop

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

    private lateinit var productAdapter: ProductAdapter
    private lateinit var fullProductList: List<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // === INIT PRODUCT LIST ===
        fullProductList = Product.getDummyProducts()

        // === SETUP PRODUCT RECYCLERVIEW ===
        val productRecycler = view.findViewById<RecyclerView>(R.id.products_grid_recycler_view)

        productAdapter = ProductAdapter(fullProductList) { product ->
            launchOrderActivity(product)
        }

        productRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = productAdapter
        }

        // === SETUP CATEGORY RECYCLER ===
        val categoryRecycler = view.findViewById<RecyclerView>(R.id.category_recycler_view)
        val categoryList = getDummyCategory()

        val categoryAdapter = CategoryAdapter(categoryList) { category ->
            if (category.name == "Tampilkan Semua") {
                showAllProducts()
            } else {
                filterProductByCategory(category.name)
            }
        }

        categoryRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }

    // === FILTER PRODUK BERDASARKAN KATEGORI ===
    private fun filterProductByCategory(catName: String) {
        val filteredList = fullProductList.filter {
            it.kategori.name.equals(catName, ignoreCase = true)
        }
        productAdapter.updateData(filteredList)
    }

    // === TAMPILKAN SEMUA PRODUK ===
    private fun showAllProducts() {
        productAdapter.updateData(fullProductList)
    }

    private fun launchOrderActivity(product: Product) {
        val intent = Intent(requireActivity(), OrderActivity::class.java).apply {
            putExtra(KEY_PRODUCT_DETAIL, product)
        }
        startActivity(intent)
    }

    // === KATEGORI DUMMY ===
    private fun getDummyCategory(): List<Category> {
        return listOf(
            Category("Tampilkan Semua", R.drawable.ic_all),
            Category("Kaos", R.drawable.kaos),
            Category("Celana", R.drawable.celana),
            Category("Jaket", R.drawable.jaket),
            Category("Sepatu", R.drawable.sepatu),
            Category("Topi", R.drawable.topi)
        )
    }
}
