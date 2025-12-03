package com.example.onlineshop


/**
 * Data class untuk merepresentasikan sebuah produk di toko online.
 * @param id ID unik produk
 * @param name Nama produk
 * @param price Harga produk
 * @param imageUrl Resource ID atau URL gambar produk (menggunakan Int sebagai placeholder R.drawable.xxx)
 */
data class Product(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Int,
    val imageUrl: Int, // Menggunakan Int sebagai placeholder untuk R.drawable.xxx
) {
    // Companion object digunakan untuk menyimpan data dummy
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