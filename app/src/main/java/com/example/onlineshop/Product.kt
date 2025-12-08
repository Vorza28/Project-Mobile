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
    val deskripsi : String,
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
                    kategori = Kategori.Jaket,
                    deskripsi = "Hoodie pria ini hadir dengan bahan fleece lembut yang hangat dan nyaman dipakai. Desainnya simpel namun tetap stylish untuk aktivitas harian. Cocok dipakai ke kampus, nongkrong, atau sekadar santai di rumah."

                ),
                Product(
                    id = 2,
                    name = "Jaket Kulit Pria Hitam",
                    price = 1200000,
                    imageUrl = R.drawable.jaketkulit,
                    brand = "Ayam",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket ini hadir dengan desain simpel namun tetap stylish untuk dipakai sehari-hari. Terbuat dari bahan yang adem dan ringan, sehingga nyaman digunakan dalam berbagai aktivitas. Cocok untuk kuliah, kerja, maupun hangout."
                ),
                Product(
                    id = 3,
                    name = "Sepatu Sneakers",
                    price = 999000,
                    imageUrl = R.drawable.sneakers,
                    brand = "Ayam",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sepatu sneakers ini dirancang dengan bantalan empuk yang nyaman untuk dipakai seharian. Bahannya ringan dan breathable sehingga kaki tetap terasa adem. Modelnya simpel dan mudah dipadukan dengan berbagai gaya outfit."
                ),
                Product(
                    id = 4,
                    name = "Celana Jeans",
                    price = 350000,
                    imageUrl = R.drawable.jeans,
                    brand = "Ayam",
                    kategori = Kategori.Celana,
                    deskripsi = "Celana jeans ini menggunakan bahan denim berkualitas yang kuat dan tidak mudah melar. Model regular fit membuatnya nyaman dipakai untuk aktivitas sehari-hari. Warna biru klasiknya mudah dipadukan dengan berbagai gaya outfit."
                ),
                Product(
                    id = 5,
                    name = "Topi Balap ngeng ngeng",
                    price = 8500000,
                    imageUrl = R.drawable.topibalap,
                    brand = "Ayam",
                    kategori = Kategori.Topi,
                    deskripsi = "Topi baseball ini hadir dengan desain simpel yang cocok untuk aktivitas sehari-hari. Bahannya ringan dan tidak panas saat dipakai. Cocok untuk melengkapi gaya casual atau outdoor."
                ),
                Product(
                    id = 6,
                    name = "Kaos Putih",
                    price = 400000,
                    imageUrl = R.drawable.kaosputih,
                    brand = "Ayam",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos putih ini dibuat dari bahan cotton lembut yang nyaman dipakai sepanjang hari. Desainnya simpel dan timeless sehingga mudah dipadukan dengan berbagai outfit. Cocok untuk dipakai kuliah, kerja, ataupun santai."
                )
            )
        }
    }
}
