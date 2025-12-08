package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale
import android.widget.TextView

class CheckoutFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var subtotalText: TextView
    private lateinit var totalText: TextView
    private lateinit var buttonBayar: Button

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
        subtotalText = view.findViewById(R.id.textSubtotal)
        totalText = view.findViewById(R.id.textSubtotalharga)
        buttonBayar = view.findViewById(R.id.btnBayarCt)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // Menggunakan data checkoutList yang sudah dimuat di onCreate
        recyclerView.adapter = CheckoutAdapter(checkoutList)

        hitungTotal()

        buttonBayar.setOnClickListener {
            pindahKeStatusPembayaran()
        }
    }

    private fun hitungTotal() {
        // Menghitung subtotal berdasarkan harga item * quantity
        val subtotal = checkoutList.sumOf { it.price.toDouble() * it.quantity }
        val biayaAdmin = 200.0 // biaya admin
        val total = subtotal + biayaAdmin

        val rupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        subtotalText.text = rupiah.format(subtotal)
        totalText.text = rupiah.format(total) // Ini adalah total akhir yang harus dibayar
    }

    private fun pindahKeStatusPembayaran() {
        val fragment = StatusFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList("checkout_item", checkoutList)
            }
        }
