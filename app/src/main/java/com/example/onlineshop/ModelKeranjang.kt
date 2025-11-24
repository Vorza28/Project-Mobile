package com.example.namaapp.model

data class ModelKeranjang(
    val gambar: Int,
    val brand: String,
    val namaProduk: String,
    val harga: String,
    var jumlah: Int = 1,
    var dipilih: Boolean = false
)
