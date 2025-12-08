package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale
import android.widget.TextView

class CheckoutFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var totalHargaText: TextView

    private var checkoutList: ArrayList<Product> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvCheckout)
        totalHargaText = view.findViewById(R.id.textSubtotalharga)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ====== AMBIL DATA DARI DeskripsiFragment ======
        arguments?.let {
            checkoutList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelableArrayList("checkout_item", Product::class.java) ?: arrayListOf()
            } else {
                @Suppress("DEPRECATION")
                it.getParcelableArrayList("checkout_item") ?: arrayListOf()
            }
        }

        // Set Adapter
        recyclerView.adapter = CheckoutAdapter(checkoutList)

        hitungTotal()
    }

    private fun hitungTotal() {
        val total = checkoutList.sumOf { it.price.toDouble() }

        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        totalHargaText.text = formatRupiah.format(total)
    }
}
