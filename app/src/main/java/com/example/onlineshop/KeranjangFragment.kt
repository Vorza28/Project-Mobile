package com.example.onlineshop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.databinding.FragmentKeranjangBinding
import java.text.NumberFormat
import java.util.Locale

class KeranjangFragment : Fragment(), KeranjangAdapter.CartListener {

    private var _binding: FragmentKeranjangBinding? = null
    private val binding get() = _binding!!

    private lateinit var cartAdapter: KeranjangAdapter
    private lateinit var cartItems: MutableList<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKeranjangBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil langsung referensi list cart (penting agar datanya hidup)
        cartItems = CartManager.getItems()

        // Setup adapter pertama kali
        cartAdapter = KeranjangAdapter(cartItems, this)

        binding.rvKeranjang.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartAdapter
        }

        binding.btnCheckout.setOnClickListener {
            // Filter item yang dicentang
            val selectedItem = cartItems.filter { it.isChecked }

            if (selectedItem.isEmpty()) {
                Toast.makeText(requireContext(), "pilih barang terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Navigasi ke Activity checkout
            navigateToCheckoutActivity(ArrayList(selectedItem))
        }

        updateUI()
    }

    private fun updateUI() {
        if (cartItems.isEmpty()) {
            binding.tvKosong.visibility = View.VISIBLE
            binding.rvKeranjang.visibility = View.GONE
            binding.txtTotal.text = "Total: ${formatRupiah(0)}"
        } else {
            binding.tvKosong.visibility = View.GONE
            binding.rvKeranjang.visibility = View.VISIBLE

            // Pastikan adapter selalu menampilkan data terbaru
            cartAdapter.notifyDataSetChanged()

            updateTotalText()
        }
    }

    private fun calculateTotal(): Long {
        return cartItems
            .filter { it.isChecked }
            .sumOf { it.price.toLong() * it.quantity }
    }

    private fun updateTotalText() {
        val total = calculateTotal()
        binding.txtTotal.text = "Total: ${formatRupiah(total)}"
    }

    private fun formatRupiah(amount: Long): String {
        val nf = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        return nf.format(amount.toDouble())
    }

    override fun onCartChanged() {
        updateTotalText()
    }

    override fun onResume() {
        super.onResume()
        // Pastikan UI diperbarui saat kembali ke fragment
        updateUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Fungsi untuk menavigasi ke OrderActivity dan membawa data keranjang.
     */
    private fun navigateToCheckoutActivity(checkoutItems: ArrayList<Product>) {
        // Menggunakan OrderActivity sebagai Activity tujuan.
        val intent = Intent(requireContext(), OrderActivity::class.java).apply {
            // Kunci "checkout_item" harus sama dengan yang diambil oleh CheckoutFragment
            putParcelableArrayListExtra("checkout_item", checkoutItems)
        }
        startActivity(intent)
    }
}