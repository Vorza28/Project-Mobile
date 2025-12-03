package com.example.onlineshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class KeranjangFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_keranjang, container, false)

        val view = inflater.inflate(R.layout.fragment_keranjang, container, false)
        val buttoncheckout = view.findViewById<Button>(R.id.btnBayar)

        buttoncheckout.setOnClickListener {
            findNavController().navigate(R.id.action_keranjang)
        }
        // Inflate the layout for this fragment
        return view
    }
}
