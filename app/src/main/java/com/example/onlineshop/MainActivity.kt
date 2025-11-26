package com.example.onlineshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menghubungkan layout activity_main.xml
        setContentView(R.layout.activity_main)

        // 1. Dapatkan NavController dari NavHostFragment
        // NavHostFragment memiliki ID: nav_host_fragment di activity_main.xml Anda
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // 2. Dapatkan BottomNavigationView
        // BottomNavigationView memiliki ID: bottom_navigation di activity_main.xml Anda
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 3. Menghubungkan BottomNavigationView dengan NavController
        // Ini memungkinkan klik pada menu navigasi untuk memicu perpindahan Fragment
        bottomNavigationView.setupWithNavController(navController)

        // 4. (Opsional) Mengatur ikon Notifikasi agar terpilih ketika Activity dimulai
        // Jika Anda ingin menyorot ikon notifikasi saat aplikasi dibuka (tidak umum)
        // bottomNavigationView.selectedItemId = R.id.nav_notifications
    }

    /**
     * Mengatur tombol 'Back' perangkat agar menavigasi ke Fragment sebelumnya (jika ada).
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}