package com.example.onlineshop

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

        val edtNama = view.findViewById<EditText>(R.id.edtNama)
        val edtUsername = view.findViewById<EditText>(R.id.edtUsername)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtNoHp = view.findViewById<EditText>(R.id.edtNoHp)
        val edtAlamat = view.findViewById<EditText>(R.id.edtAlamat)
        val edtKota = view.findViewById<EditText>(R.id.edtKota)
        val edtKodePos = view.findViewById<EditText>(R.id.edtKodePos)

        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)

        edtNama.setText(userPref.getUserName())
        edtUsername.setText(userPref.getUsername())
        edtEmail.setText(userPref.getUserEmail())
        edtNoHp.setText(userPref.getUserPhone())
        edtAlamat.setText(userPref.getUserAddress())
        edtKota.setText(userPref.getUserCity())
        edtKodePos.setText(userPref.getPostal())

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        btnSimpan.setOnClickListener {

            val nama = edtNama.text.toString()
            val username = edtUsername.text.toString()
            val email = edtEmail.text.toString()
            val noHp = edtNoHp.text.toString()
            val alamat = edtAlamat.text.toString()
            val kota = edtKota.text.toString()
            val kodePos = edtKodePos.text.toString()

            if (nama.isEmpty() || username.isEmpty() || email.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi data dengan lengkap", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

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

        // BAGIAN LOGOUT SUDAH DIHAPUS
    }
}
