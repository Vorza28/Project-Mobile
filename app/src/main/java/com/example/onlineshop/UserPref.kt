package com.example.onlineshop

import android.content.Context

class UserPref(context: Context) {

    private val pref = context.getSharedPreferences("user_pref", Context.MODE_PRIVATE)

    fun saveUser(
        name: String,
        username: String,
        email: String,
        phone: String,
        address: String,
        city: String,
        postal: String
    ) {
        pref.edit().apply {
            putString("user_name", name)
            putString("user_username", username)   // ➜ tambahan
            putString("user_email", email)
            putString("user_phone", phone)
            putString("user_address", address)
            putString("user_city", city)
            putString("user_postal", postal)
            apply()
        }
    }

    fun getUserName(): String = pref.getString("user_name", "") ?: ""
    fun getUsername(): String = pref.getString("user_username", "") ?: ""   // ➜ tambahan
    fun getUserEmail(): String = pref.getString("user_email", "") ?: ""
    fun getUserPhone(): String = pref.getString("user_phone", "") ?: ""
    fun getUserAddress(): String = pref.getString("user_address", "") ?: ""
    fun getUserCity(): String = pref.getString("user_city", "") ?: ""
    fun getPostal(): String = pref.getString("user_postal", "") ?: ""

    fun clear() {
        pref.edit().clear().apply()
    }
}
