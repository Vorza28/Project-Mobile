package com.example.onlineshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        val btnPesan = view.findViewById<Button>(R.id.buttonPesan)

        btnPesan.setOnClickListener {

            // ----- DATA YANG DIKIRIM -----
            val idPesanan = "INV-${System.currentTimeMillis()}"
            val totalBayar = "Rp 150.000"
            val tanggal = "1 Desember 2025"

            val bundle = Bundle()
            bundle.putString("order_id", idPesanan)
            bundle.putString("order_total", totalBayar)
            bundle.putString("order_date", tanggal)


            findNavController().navigate(R.id.paymentStatusFragment, bundle)
        }

        return view
    }
}
