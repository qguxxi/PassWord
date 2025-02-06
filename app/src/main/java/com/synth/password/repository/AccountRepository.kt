package com.synth.password.repository

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.synth.password.data.local.Account

class AccountRepository {

    private val database = Firebase.database.reference

    // Hàm để lưu dữ liệu vào Firebase
    fun saveAccountData(account: Account) {
        val newAccountRef = database.child("accounts").push() // Tạo một key tự động
        account.id = newAccountRef.key ?: "" // Gán ID tự động
        newAccountRef.setValue(account) // Lưu dữ liệu
    }
}