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
    var isChecked: Boolean = false,
    val kategori: Kategori,
) : Parcelable {

    enum class Kategori {
        Kaos, Celana, Jaket, Sepatu, Topi
    }

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
                    brand = "Ayam",
                    kategori = Kategori.Jaket
                ),
                Product(
                    id = 2,
                    name = "Jaket Kulit Pria Hitam",
                    price = 1200000,
                    imageUrl = R.drawable.jaketkulit,
                    brand = "Ayam",
                    kategori = Kategori.Jaket
                ),
                Product(
                    id = 3,
                    name = "Sepatu Sneakers",
                    price = 999000,
                    imageUrl = R.drawable.sneakers,
                    brand = "Ayam",
                    kategori = Kategori.Sepatu
                ),
                Product(
                    id = 4,
                    name = "Celana Jeans",
                    price = 350000,
                    imageUrl = R.drawable.jeans,
                    brand = "Ayam",
                    kategori = Kategori.Celana
                ),
                Product(
                    id = 5,
                    name = "Topi Balap ngeng ngeng",
                    price = 8500000,
                    imageUrl = R.drawable.topibalap,
                    brand = "Ayam",
                    kategori = Kategori.Topi
                ),
                Product(
                    id = 6,
                    name = "Kaos Putih",
                    price = 400000,
                    imageUrl = R.drawable.kaosputih,
                    brand = "Ayam",
                    kategori = Kategori.Kaos
                )
            )
        }
    }
}
