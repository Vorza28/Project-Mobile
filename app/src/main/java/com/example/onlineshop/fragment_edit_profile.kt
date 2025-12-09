package com.example.onlineshop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userPref = UserPref(requireContext())

        // Ambil ID dari XML
        val edtNama = view.findViewById<EditText>(R.id.edtNama)
        val edtUsername = view.findViewById<EditText>(R.id.edtUsername)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtNoHp = view.findViewById<EditText>(R.id.edtNoHp)
        val edtAlamat = view.findViewById<EditText>(R.id.edtAlamat)
        val edtKota = view.findViewById<EditText>(R.id.edtKota)
        val edtKodePos = view.findViewById<EditText>(R.id.edtKodePos)

        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)

        // === TAMPILKAN DATA TERBARU KE FORM ===
        edtNama.setText(userPref.getUserName())
        edtUsername.setText(userPref.getUsername())
        edtEmail.setText(userPref.getUserEmail())
        edtNoHp.setText(userPref.getUserPhone())
        edtAlamat.setText(userPref.getUserAddress())
        edtKota.setText(userPref.getUserCity())
        edtKodePos.setText(userPref.getPostal())

        // === BUTTON BACK ===
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // === BUTTON SIMPAN ===
        btnSimpan.setOnClickListener {

            val nama = edtNama.text.toString()
            val username = edtUsername.text.toString()
            val email = edtEmail.text.toString()
            val noHp = edtNoHp.text.toString()
            val alamat = edtAlamat.text.toString()
            val kota = edtKota.text.toString()
            val kodePos = edtKodePos.text.toString()

            // Validasi minimal
            if (nama.isEmpty() || username.isEmpty() || email.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi data dengan lengkap", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // === SIMPAN KE UserPref ===
            userPref.saveUser(
                name = nama,
                username = username,
                email = email,
                phone = noHp,
                address = alamat,
                city = kota,
                postal = kodePos
            )

            Toast.makeText(requireContext(), "Perubahan Disimpan!", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }

        // === BUTTON LOGOUT ===
        btnLogout.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
