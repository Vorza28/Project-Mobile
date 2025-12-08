package com.example.onlineshop

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale
import android.widget.TextView

class StatusFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var subtotalText: TextView
    private lateinit var totalText: TextView
    private lateinit var btnBeranda: Button

    private var listProduk: ArrayList<Product> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_status_pembayaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvCheckout)
        subtotalText = view.findViewById(R.id.textSubtotalharga)
        totalText = view.findViewById(R.id.textTotalSemuaBelanja)
        btnBeranda = view.findViewById(R.id.btnBeranda)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Ambil data dari CheckoutFragment
        arguments?.let {
            listProduk = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelableArrayList("checkout_item", Product::class.java) ?: arrayListOf()
            } else {
                @Suppress("DEPRECATION")
                it.getParcelableArrayList<Product>("checkout_item") ?: arrayListOf()
            }
        }

        // Adapter TANPA listener (hanya 1 parameter)
        recyclerView.adapter = CheckoutAdapter(listProduk)

        hitungTotal()

        btnBeranda.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun hitungTotal() {
        val subtotal = listProduk.sumOf { it.price * it.quantity }
        val pajak = 200
        val total = subtotal + pajak

        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))

        subtotalText.text = formatRupiah.format(subtotal.toDouble())
        totalText.text = formatRupiah.format(total.toDouble())
    }
}
