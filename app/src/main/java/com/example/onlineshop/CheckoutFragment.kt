package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CheckoutFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var subtotalText: TextView
    private lateinit var totalText: TextView
    private lateinit var buttonBayar: Button

    // Data item checkout akan dimuat di sini dari Arguments
    private var checkoutList: ArrayList<Product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ambil data dari Arguments yang disiapkan oleh Activity penampung (OrderActivity)
        arguments?.let {
            checkoutList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelableArrayList("checkout_item", Product::class.java) ?: arrayListOf()
            } else {
                @Suppress("DEPRECATION")
                it.getParcelableArrayList<Product>("checkout_item") ?: arrayListOf()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvCheckout)
        subtotalText = view.findViewById(R.id.textSubtotalharga)
        totalText = view.findViewById(R.id.textTotalSemuaBelanja)
        buttonBayar = view.findViewById(R.id.btnBayarCt)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CheckoutAdapter(checkoutList)

        hitungTotal()

        buttonBayar.setOnClickListener {
            prosesPembayaranDanNotifikasi()
            pindahKeStatusPembayaran()
        }
        // -----------------------------------------------------------------
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

    // --- FUNGSI BARU: Untuk membuat notifikasi dan menyimpannya ---
    private fun prosesPembayaranDanNotifikasi() {
        val totalItems = checkoutList.sumOf { it.quantity }

        val newNotification = NotificationItem(
            title = "Pesanan Berhasil Dibuat",
            message = "Pesanan Anda sebanyak $totalItems item berhasil diproses. Cek status di halaman Riwayat Pesanan.",
            type = NotificationType.ORDER_SUCCESS
        )

        // Simpan notifikasi ke NotificationManager (agar bisa dibaca NotificationsFragment)
        NotificationManager.addNotification(newNotification)
    }
    // ---------------------------------------------

    private fun pindahKeStatusPembayaran() {
        val fragment = StatusFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList("checkout_item", checkoutList)
            }
        }

        // Navigasi ke StatusFragment dalam Activity yang sama (OrderActivity)
        parentFragmentManager.beginTransaction()
            .replace(R.id.order_fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}