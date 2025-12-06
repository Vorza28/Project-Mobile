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

        val edtNama = view.findViewById<EditText>(R.id.edtNama)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtNoHp = view.findViewById<EditText>(R.id.edtNoHp)
        val edtAlamat = view.findViewById<EditText>(R.id.edtAlamat)
        val edtKota = view.findViewById<EditText>(R.id.edtKota)
        val edtKodePos = view.findViewById<EditText>(R.id.edtKodePos)

        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        // === TOMBOL BACK (DITAMBAHKAN) ===
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        btnSimpan.setOnClickListener {
            val nama = edtNama.text.toString()
            val email = edtEmail.text.toString()
            val noHp = edtNoHp.text.toString()

            if (nama.isEmpty() || email.isEmpty() || noHp.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi data dengan lengkap", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(requireContext(), "Perubahan Disimpan!", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }

        btnLogout.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
