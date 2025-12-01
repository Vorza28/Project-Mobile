package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class PaymentStatusFragment : Fragment() {

    private lateinit var tvPaymentStatus: TextView
    private lateinit var tvPaymentDescription: TextView
    private lateinit var tvOrderId: TextView
    private lateinit var tvOrderTotal: TextView
    private lateinit var tvOrderDate: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate layout
        val view = inflater.inflate(R.layout.fragment_status_pembayaran, container, false)

        // inisialisasi view
        tvPaymentStatus = view.findViewById(R.id.tvPaymentStatus)
        tvPaymentDescription = view.findViewById(R.id.tvPaymentDescription)
        tvOrderId = view.findViewById(R.id.tvOrderId)
        tvOrderTotal = view.findViewById(R.id.tvOrderTotal)
        tvOrderDate = view.findViewById(R.id.tvOrderDate)

        // Contoh mengubah status (dummy)
        updateStatus("Sudah Dibayar", "Pembayaran telah diterima.", true)

        return view
    }

    private fun updateStatus(status: String, desc: String, isSuccess: Boolean) {
        tvPaymentStatus.text = status
        tvPaymentDescription.text = desc

        // Tetap hitam putih
        tvPaymentStatus.setTextColor(resources.getColor(android.R.color.black))
    }
}