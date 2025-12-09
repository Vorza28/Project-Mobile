package com.example.onlineshop

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DiscoverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productList = Product.getDummyProducts()
        val productsRecyclerView = view.findViewById<RecyclerView>(R.id.discover_products_grid_recycler_view)
        val searchBar = view.findViewById<EditText>(R.id.discover_search_bar)

        val productAdapter = ProductAdapter(productList) { product ->
            navigateToProductDescription(product)
        }

        productsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        productsRecyclerView.adapter = productAdapter

        // === SEARCH LISTENER ===
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                productAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun navigateToProductDescription(product: Product) {
        val intent = Intent(requireActivity(), OrderActivity::class.java).apply {
            putExtra("product_detail", product)
        }
        startActivity(intent)
    }
}
