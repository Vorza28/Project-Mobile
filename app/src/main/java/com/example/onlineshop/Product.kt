package com.example.onlineshop

import android.os.Parcelable
import com.example.onlineshop.R.drawable
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
                    price = 320000,
                    imageUrl = R.drawable.hoodie,
                    brand = "UrbanFlex",
                    kategori = Kategori.Jaket,
                    deskripsi = "Hoodie pria ini dibuat dari bahan fleece premium yang lembut dan hangat. Desainnya simpel namun tetap modern untuk dipakai di berbagai aktivitas. Cocok untuk kuliah, nongkrong, atau sekadar santai di rumah."
                ),

                Product(
                    id = 2,
                    name = "Jaket Kulit Pria Hitam",
                    price = 680000,
                    imageUrl = R.drawable.jaketkulit,
                    brand = "BlackForge",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket kulit ini hadir dengan tampilan elegan dan maskulin. Bahan kulit sintetis tebal membuatnya nyaman sekaligus tahan lama. Sangat cocok untuk gaya harian maupun riding malam hari."
                ),

                Product(
                    id = 3,
                    name = "Sepatu Sneakers",
                    price = 459000,
                    imageUrl = R.drawable.sneakers,
                    brand = "StrideOne",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sneakers ini dilengkapi bantalan empuk yang nyaman dipakai seharian. Material mesh membuat kaki tetap adem meski digunakan lama. Modelnya simpel sehingga cocok untuk berbagai outfit casual."
                ),

                Product(
                    id = 4,
                    name = "Celana Jeans",
                    price = 275000,
                    imageUrl = R.drawable.jeans,
                    brand = "DenimCore",
                    kategori = Kategori.Celana,
                    deskripsi = "Celana jeans ini dibuat dari denim kuat yang tidak mudah melar. Potongan regular fit memberi kenyamanan saat dipakai bergerak. Warna birunya juga mudah dipadukan dengan segala gaya."
                ),

                Product(
                    id = 5,
                    name = "Topi Balap ngeng ngeng",
                    price = 159000,
                    imageUrl = R.drawable.topibalap,
                    brand = "TurboCap",
                    kategori = Kategori.Topi,
                    deskripsi = "Topi ini memiliki desain sporty khas balap yang mencuri perhatian. Bahan ringan membuatnya nyaman dipakai sepanjang hari. Cocok untuk melengkapi gaya casual ataupun outdoor."
                ),

                Product(
                    id = 6,
                    name = "Kaos Putih",
                    price = 99000,
                    imageUrl = R.drawable.kaosputih,
                    brand = "BasicWear",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos putih ini menggunakan cotton lembut yang nyaman dan adem di kulit. Desain sederhana membuatnya fleksibel dipadukan dengan apa saja. Cocok untuk kuliah, kerja, hingga aktivitas santai."
                ),

                Product(
                    id = 7,
                    name = "Sepatu Hitam Putih",
                    price = 299000,
                    imageUrl = R.drawable.sepatu_hitam_putih,
                    brand = "Footstep",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sepatu ini menggabungkan warna hitam dan putih yang klasik serta mudah dipadukan. Solnya empuk sehingga nyaman untuk aktivitas seharian. Cocok untuk jalan santai maupun dipakai harian."
                ),

                Product(
                    id = 8,
                    name = "Sepatu Putih",
                    price = 310000,
                    imageUrl = R.drawable.sepatu_hitam_putih,
                    brand = "WhiteStep",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sneakers putih ini memberikan tampilan clean dan modern. Bahannya ringan sehingga nyaman dipakai dalam aktivitas sehari-hari. Cocok untuk gaya casual ataupun semi-formal."
                ),

                Product(
                    id = 9,
                    name = "Adidas Pink",
                    price = 550000,
                    imageUrl = R.drawable.adidas_pink,
                    brand = "Adidas",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sneakers berwarna pink ini memberi tampilan cerah dan stylish. Dilengkapi bantalan empuk yang nyaman dipakai sepanjang hari. Cocok untuk olahraga ringan ataupun hangout."
                ),

                Product(
                    id = 10,
                    name = "Convers",
                    price = 480000,
                    imageUrl = R.drawable.covers,
                    brand = "Converse",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sepatu ini menghadirkan gaya klasik yang tak lekang oleh waktu. Bahannya kuat dan nyaman untuk aktivitas harian. Sangat cocok untuk kamu yang suka tampilan casual simpel."
                ),

                Product(
                    id = 11,
                    name = "Sepatu Putih",
                    price = 285000,
                    imageUrl = R.drawable.sepatu_putih,
                    brand = "CleanStep",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sepatu putih polos dengan desain sederhana namun elegan. Materialnya ringan sehingga nyaman dipakai bergerak seharian. Sangat fleksibel dipadukan dengan berbagai outfit."
                ),

                Product(
                    id = 12,
                    name = "Jacket Jeans",
                    price = 360000,
                    imageUrl = R.drawable.jaket_jeans,
                    brand = "StoneDenim",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket jeans ini dibuat dari denim tebal yang tahan lama. Desain klasik membuatnya cocok untuk semua gaya casual. Cocok digunakan saat nongkrong atau bepergian."
                ),

                Product(
                    id = 13,
                    name = "Jacket Kulit",
                    price = 650000,
                    imageUrl = R.drawable.jaket_kulit,
                    brand = "MotoBlack",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket kulit ini memberi tampilan bold dan modern. Bahan kulit sintetisnya halus dan nyaman dipakai. Cocok untuk riding atau sekadar tampil lebih stylish."
                ),

                Product(
                    id = 13,
                    name = "Jacket Crop",
                    price = 310000,
                    imageUrl = R.drawable.croped_jaket,
                    brand = "CropStyle",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket crop ini memberikan tampilan modis dan energik. Bahannya ringan sehingga nyaman digunakan sepanjang hari. Cocok untuk aktivitas santai maupun jalan-jalan."
                ),

                Product(
                    id = 13,
                    name = "Broklyn Hoodie",
                    price = 295000,
                    imageUrl = R.drawable.broklyn_jaket,
                    brand = "BrooklynWear",
                    kategori = Kategori.Jaket,
                    deskripsi = "Hoodie ini hadir dengan desain streetwear yang sedang digemari. Materialnya lembut dan hangat saat dipakai. Cocok untuk aktivitas santai, kampus, maupun nongkrong."
                ),

                Product(
                    id = 13,
                    name = "Jacket Kulit",
                    price = 710000,
                    imageUrl = R.drawable.jaketkulit,
                    brand = "SteelRider",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket kulit yang memberi kesan premium dan elegan. Bahannya kuat namun tetap nyaman untuk dipakai bergerak. Cocok untuk kamu yang ingin tampil lebih stylish dan percaya diri."
                ),
                Product(
                    id = 13,
                    name = "Jacket Crop",
                    price = 400000,
                    imageUrl = drawable.croped_jaket,
                    brand = "Ayam",
                    kategori = Kategori.Jaket,
                    deskripsi = "Kaos putih ini dibuat dari bahan cotton lembut yang nyaman dipakai sepanjang hari. Desainnya simpel dan timeless sehingga mudah dipadukan dengan berbagai outfit. Cocok untuk dipakai kuliah, kerja, ataupun santai."
                ),
                Product(
                    id = 13,
                    name = "Broklyn Hoodie",
                    price = 400000,
                    imageUrl = drawable.broklyn_jaket,
                    brand = "Broklyn",
                    kategori = Kategori.Jaket,
                    deskripsi = "Kaos putih ini dibuat dari bahan cotton lembut yang nyaman dipakai sepanjang hari. Desainnya simpel dan timeless sehingga mudah dipadukan dengan berbagai outfit. Cocok untuk dipakai kuliah, kerja, ataupun santai."
                ),

                Product(
                    id = 13,
                    name = "Jacket Kulit",
                    price = 400000,
                    imageUrl = drawable.jaketkulit,
                    brand = "Ayam",
                    kategori = Kategori.Jaket,
                    deskripsi = "Kaos putih ini dibuat dari bahan cotton lembut yang nyaman dipakai sepanjang hari. Desainnya simpel dan timeless sehingga mudah dipadukan dengan berbagai outfit. Cocok untuk dipakai kuliah, kerja, ataupun santai."
                ),
                Product(
                    id = 14,
                    name = "Celana Chino Slim Fit Pria",
                    price = 209000,
                    imageUrl = drawable.celana_slim,
                    brand = "ChinoCraft",
                    kategori = Kategori.Celana,
                    deskripsi = "Celana chino dengan potongan slim fit yang memberi tampilan rapi dan semi-formal. Bahannya sedikit stretch sehingga nyaman dipakai sepanjang hari. Pas dipadukan dengan kemeja atau kaos polos."
                ),
                Product(
                    id = 15,
                    name = "Sepatu Slip-On Casual",
                    price = 289000,
                    imageUrl = drawable.sepatu_slip,
                    brand = "EasyWalk",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sepatu slip-on ini praktis dipakai tanpa tali, cocok untuk gaya santai atau kasual. Sol empuk dan ringan membuat kaki tetap nyaman. Ideal untuk pemakaian harian atau jalan santai."
                ),
                Product(
                    id = 15,
                    name = "Celana Cargo Relaxed Fit",
                    price = 229000,
                    imageUrl = drawable.celana_cargo,
                    brand = "CargoZone",
                    kategori = Kategori.Celana,
                    deskripsi = "Celana cargo dengan potongan relaxed fit, nyaman untuk aktivitas harian maupun outdoor. Terdapat banyak kantong yang fungsional untuk membawa barang. Memberi kesan kasual & praktis."
                ),
                Product(
                    id = 16,
                    name = "Topi Bucket Vintage",
                    price = 139000,
                    imageUrl = drawable.topi_rajut,
                    brand = "HatWorld",
                    kategori = Kategori.Topi,
                    deskripsi = "Topi bucket dengan nuansa vintage yang cocok untuk style streetwear atau casual. Bahannya adem dan ringan, nyaman dipakai di cuaca panas. Pas dipadukan dengan outfit santai seperti kaos dan celana cargo."
                ),
                Product(
                    id = 17,
                    name = "Kaos Grafik",
                    price = 99000,
                    imageUrl = drawable.kaos_grafik,
                    brand = "GrafikWear",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos dengan desain grafis unik yang cocok untuk gaya streetwear. Bahannya nyaman dan adem, cocok dipakai sehari-hari. Menjadi statement outfit tanpa perlu banyak tambahan aksesori."
                ),
                Product(
                    id = 18,
                    name = "Jaket Parka Casual",
                    price = 319000,
                    imageUrl = drawable.jaket_parka,
                    brand = "ParkaUrban",
                    kategori = Kategori.Jaket,
                    deskripsi = "Jaket parka dengan potongan casual yang cocok untuk cuaca dingin atau malam hari. Bahan tebal memberi rasa hangat dan nyaman. Tampilan tetap stylish meski dipakai untuk aktivitas luar ruangan."
                ),
                Product(
                    id = 19,
                    name = "Sepatu Boots Kulit",
                    price = 139000,
                    imageUrl = drawable.sepatu_boots,
                    brand = "BootMaster",
                    kategori = Kategori.Sepatu,
                    deskripsi = "Sepatu boots berbahan kulit yang kuat dan tahan lama. Memberi kesan maskulin dan tangguh saat dipakai. Cocok untuk gaya kasual maupun semi-formal dengan jaket atau jeans."
                ),
                Product(
                    id = 20,
                    name = "Topi Bucket Vintage",
                    price = 139000,
                    imageUrl = drawable.topi_rajut,
                    brand = "KnitCap",
                    kategori = Kategori.Topi,
                    deskripsi = "Topi beanie rajut ini cocok untuk cuaca dingin atau musim hujan. Material rajut membuat kepala tetap hangat dan nyaman. Cocok untuk tampilan kasual dan santai."
                ),
                Product(
                    id = 21,
                    name = "Kaos Lengan Panjang Basic",
                    price = 109000,
                    imageUrl = drawable.kaos_panjang,
                    brand = "BasicWear",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos lengan panjang ini terbuat dari katun lembut dan adem, nyaman dipakai sehari-hari. Desainnya simpel dan mudah dipadukan dengan berbagai outfit. Cocok sebagai lapisan luar di cuaca dingin atau malam hari."
                ),
                Product(
                    id = 22,
                    name = "Celana Jogger Sporty",
                    price = 187000,
                    imageUrl = drawable.celana_joger,
                    brand = "JoggerFit",
                    kategori = Kategori.Celana,
                    deskripsi = "Celana jogger dengan potongan sporty, nyaman untuk aktivitas santai maupun olahraga ringan. Bahan jersey lembut dan fleksibel mengikuti gerak tubuh. Pas dipadukan dengan kaos atau hoodie."
                ),
                Product(
                    id = 23,
                    name = "Kaos Abu Minimalis",
                    price = 125000,
                    imageUrl = R.drawable.kaos_abu,
                    brand = "GreyTone",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos abu warna netral dengan potongan regular fit yang cocok untuk sehari-hari. Bahannya ringan dan adem sehingga nyaman dipakai dalam cuaca panas. Desain minimalis membuatnya fleksibel dipadukan dengan celana maupun jaket."
                ),

                Product(
                    id = 24,
                    name = "Kaos Strip Casual",
                    price = 149000,
                    imageUrl = R.drawable.kaos_strip,
                    brand = "StripeLine",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos bergaris horizontal dengan gaya casual yang easygoing. Kain katunnya lembut dan nyaman di kulit, cocok untuk aktivitas harian. Bisa dipadukan dengan celana jeans atau chino untuk tampilan santai."
                ),

                Product(
                    id = 25,
                    name = "Kaos Lengan Panjang Raglan",
                    price = 179000,
                    imageUrl = R.drawable.kaos_raglan,
                    brand = "RaglanWear",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos lengan panjang dengan potongan raglan yang memberi kesan sporty. Materialnya sedikit stretch sehingga nyaman dipakai bergerak aktif. Cocok untuk hangout santai maupun kegiatan outdoor ringan."
                ),

                Product(
                    id = 26,
                    name = "Kaos Oversize Streetwear",
                    price = 165000,
                    imageUrl = R.drawable.kaos_oversize,
                    brand = "UrbanEdge",
                    kategori = Kategori.Kaos,
                    deskripsi = "Kaos model oversize dengan gaya streetwear kekinian. Bahannya soft dan jatuh membuat tampilan tetap nyaman dan stylish. Pas dipakai jalan-jalan, nongkrong, atau casual wear harian."
                ),

















                )
        }
    }
}
