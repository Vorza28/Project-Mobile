package com.example.onlineshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Fragment untuk menu Profil
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Ganti dengan layout fragment_profile.xml Anda
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}