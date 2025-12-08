package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class StatusFragment : Fragment() {

    private lateinit var recyclerStatus: RecyclerView
    private lateinit var textTotalStatus: TextView

    private var listCheckout: ArrayList<Product> = arrayListOf()
    private var totalHarga: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_status_pembayaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerStatus = view.findViewById(R.id.rvStatus)
        textTotalStatus = view.findViewById(R.id.textTotalStatus)

        recyclerStatus.layoutManager = LinearLayoutManager(requireContext())

        // Ambil data dari CheckoutFragment
        arguments?.let {
            listCheckout = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelableArrayList("checkout_item", Product::class.java) ?: arrayListOf()
            } else {
                @Suppress("DEPRECATION")
                it.getParcelableArrayList("checkout_item") ?: arrayListOf()
            }

            totalHarga = it.getDouble("total_harga", 0.0)
        }

        recyclerStatus.adapter = CheckoutAdapter(listCheckout)

        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        textTotalStatus.text = formatRupiah.format(totalHarga)
    }
}
