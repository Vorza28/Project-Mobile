package com.example.onlineshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class DeskripsiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deskripsi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonKeranjang = view.findViewById<Button>(R.id.buttonKeranjang)
        val buttonBayar = view.findViewById<Button>(R.id.buttonBayar)


        buttonBayar.setOnClickListener {
            findNavController().navigate(R.id.checkoutFragment )
        }

        buttonKeranjang.setOnClickListener {
            findNavController().navigate(R.id.nav_cart)
        }


    }
}