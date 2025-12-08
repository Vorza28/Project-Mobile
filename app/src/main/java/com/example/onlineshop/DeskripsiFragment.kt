package com.example.onlineshop

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.NumberFormat
import java.util.Locale

class DeskripsiFragment : Fragment() {

    private lateinit var productImageView: ImageView
    private lateinit var brandTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var buyButton: Button
    private lateinit var buttonKeranjang: Button

    private var product: Product? = null

    companion object {
        private const val ARG_PRODUCT = "product_data"

        fun newInstance(product: Product): DeskripsiFragment {
            return DeskripsiFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PRODUCT, product)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable(ARG_PRODUCT, Product::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.getParcelable(ARG_PRODUCT)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_deskripsi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productImageView = view.findViewById(R.id.imageDeskripsi)
        brandTextView = view.findViewById(R.id.textView6)
        nameTextView = view.findViewById(R.id.textViewNamaProduk)
        priceTextView = view.findViewById(R.id.textViewHarga)
        buyButton = view.findViewById(R.id.buttonBayar)
        buttonKeranjang = view.findViewById(R.id.buttonKeranjang)

        displayProductData()

        // Tombol Checkout
        buyButton.setOnClickListener {
            product?.let { navigateToCheckout(it) }
        }

        // Tombol Tambah ke Keranjang
        buttonKeranjang.setOnClickListener {
            product?.let { addToCart(it) }
        }
    }

    private fun displayProductData() {
        val p = product ?: return

        productImageView.setImageResource(p.imageUrl)
        brandTextView.text = p.brand
        nameTextView.text = p.name

        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        priceTextView.text = formatRupiah.format(p.price.toDouble())
    }

    private fun navigateToCheckout(product: Product) {

        // -------------------------------------------
        // Pastikan product yang dikirim memiliki quantity = 1
        // -------------------------------------------
        val checkoutProduct = product.copy(quantity = 1)

        val list = arrayListOf(checkoutProduct)

        val checkoutFragment = CheckoutFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList("checkout_item", list)
            }
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.order_fragment_container, checkoutFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun addToCart(product: Product) {
        CartManager.addItem(product)
        Toast.makeText(requireContext(), "Barang dimasukkan ke keranjang", Toast.LENGTH_SHORT).show()
    }
}
