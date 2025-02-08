package com.synth.password.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.synth.password.data.local.Account

class AccountRepository() {
    private val database = Firebase.database.reference


    // Hàm để lưu dữ liệu vào Firebase
    suspend fun saveAccountData(account: Account) {
        val newAccountRef = database.child("accounts").push() // Tạo một key tự động
        newAccountRef.setValue(account) // Lưu dữ liệu
    }

    fun getAccountData(accountId: String, callback: (Account?) -> Unit) {
        val accountRef = database.child("accounts").child(accountId)
        accountRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val account = snapshot.getValue(Account::class.java)
                callback(account)
            }
            override fun onCancelled(error: DatabaseError) {
                // Handle error
                callback(null)
            }
        })
    }
}
