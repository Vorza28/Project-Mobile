package com.example.onlineshop

/**
 * Penyimpanan keranjang global sepanjang lifecycle aplikasi.
 * getItems() mengembalikan MutableList sehingga adapter/fragment dapat bekerja langsung pada objek yang sama.
 */
object CartManager {
    private val cartItems = mutableListOf<Product>()

    fun addItem(product: Product) {
        // jika sudah ada, cukup tambah quantity
        val existing = cartItems.find { it.id == product.id }
        if (existing != null) {
            existing.quantity += 1
        } else {
            // tambahkan salinan agar tidak merubah instance original jika diperlukan
            cartItems.add(product.copy(quantity = 1))
        }
    }

    fun removeItem(product: Product) {
        cartItems.removeIf { it.id == product.id }
    }

    fun clear() {
        cartItems.clear()
    }

    // Kembalikan mutable list supaya perubahan quantity/isChecked mempengaruhi sumber data
    fun getItems(): MutableList<Product> = cartItems
}
