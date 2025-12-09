package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userPref = UserPref(requireContext())

        val txtNama = view.findViewById<TextView>(R.id.txtNama)
        val txtId = view.findViewById<TextView>(R.id.txtId)
        val btnEditProfile = view.findViewById<Button>(R.id.button)

        // === SINKRONKAN DENGAN DATA YANG DISIMPAN ===
        txtNama.text = userPref.getUsername()   // Username tampil sebagai nama pengguna
        txtId.text = userPref.getUserEmail()    // Email tampil sebagai ID pengguna

        btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }
    }
}
