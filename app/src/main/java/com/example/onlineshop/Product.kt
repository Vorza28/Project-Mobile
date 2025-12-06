package com.example.onlineshop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val imageUrl: Int,
    var quantity: Int = 1,
    var isChecked: Boolean = false
) : Parcelable {

    companion object {

        /**
         * Mengembalikan daftar produk dummy untuk ditampilkan di HomeFragment atau DiscoverFragment.
         */
        fun getDummyProducts(): List<Product> {
            return listOf(
                Product(
                    id = 1,
                    name = "Hoodie Pria",
                    price = 750000,
                    imageUrl = R.drawable.hoodie,
                    brand = "Ayam"
                ),
                Product(
                    id = 2,
                    name = "Jaket Kulit Pria Hitam",
                    price = 1200000,
                    imageUrl = R.drawable.jaketkulit,
                    brand = "Ayam"
                ),
                Product(
                    id = 3,
                    name = "Sepatu Sneakers",
                    price = 999000,
                    imageUrl = R.drawable.sneakers,
                    brand = "Ayam"
                ),
                Product(
                    id = 4,
                    name = "Celana Jeans",
                    price = 350000,
                    imageUrl = R.drawable.jeans,
                    brand = "Ayam"
                ),
                Product(
                    id = 5,
                    name = "Topi Balap ngeng ngeng",
                    price = 8500000,
                    imageUrl = R.drawable.topibalap,
                    brand = "Ayam"
                ),
                Product(
                    id = 6,
                    name = "Kaos Putih",
                    price = 400000,
                    imageUrl = R.drawable.kaosputih,
                    brand = "Ayam"
                )
            )
        }
    }
}
