package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CheckoutFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var totalHargaText: TextView
    private lateinit var buttonPesan: Button

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
        buttonPesan = view.findViewById(R.id.buttonPesan)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Ambil data dari DeskripsiFragment
        arguments?.let {
            checkoutList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelableArrayList("checkout_item", Product::class.java) ?: arrayListOf()
            } else {
                @Suppress("DEPRECATION")
                it.getParcelableArrayList("checkout_item") ?: arrayListOf()
            }
        }

        recyclerView.adapter = CheckoutAdapter(checkoutList)

        hitungTotal()

        // ======== AKSI TOMBOL PESAN =========
        buttonPesan.setOnClickListener {
            findNavController().navigate(R.id.action_checkout_to_status)
        }
    }

    private fun hitungTotal() {
        val total = checkoutList.sumOf { it.price.toDouble() }
        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        totalHargaText.text = formatRupiah.format(total)
    }
}
