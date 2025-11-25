package com.example.onlineshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Deklarasi variabel untuk komponen UI
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var masukButton: Button

    // Anda dapat mengganti ini dengan kredensial yang valid dari database/API
    private val VALID_EMAIL = "user@example.com"
    private val VALID_PASSWORD = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menghubungkan layout activity_login.xml
        setContentView(R.layout.activity_login)

        // 1. Inisialisasi komponen UI dari layout XML
        emailEditText = findViewById(R.id.editTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextPassword)
        masukButton = findViewById(R.id.buttonMasuk)

        // 2. Menambahkan listener pada tombol "Masuk"
        masukButton.setOnClickListener {
            handleLogin()
        }

        // Anda juga bisa menambahkan listener untuk tombol Google
        // findViewById<ImageButton>(R.id.googleButton).setOnClickListener {
        //     Toast.makeText(this, "Melakukan Login dengan Google...", Toast.LENGTH_SHORT).show()
        // }
    }

    /**
     * Fungsi untuk menangani proses login.
     * Saat ini, hanya melakukan validasi sederhana hardcode.
     */
    private fun handleLogin() {
        // Mendapatkan input dari EditText dan menghapus spasi di awal/akhir
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Validasi input
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email dan Password tidak boleh kosong.", Toast.LENGTH_LONG).show()
            return // Menghentikan fungsi jika input kosong
        }

        // 3. Logika Verifikasi (Simulasi)
        if (email == VALID_EMAIL && password == VALID_PASSWORD) {
            // Jika login berhasil
            Toast.makeText(this, "Login Berhasil! Selamat datang.", Toast.LENGTH_SHORT).show()

            // 4. Navigasi ke MainActivity (Menu Home)
            navigateToMainActivity()
        } else {
            // Jika login gagal
            Toast.makeText(this, "Email atau Password salah. Coba lagi.", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Memulai MainActivity dan menutup LoginActivity.
     */
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        // Flag: Mencegah pengguna kembali ke layar login dengan tombol 'Back'
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish() // Menutup LoginActivity agar tidak bisa diakses dari MainActivity
    }
}