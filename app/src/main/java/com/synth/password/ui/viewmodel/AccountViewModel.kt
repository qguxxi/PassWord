package com.synth.password.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import com.synth.password.data.local.Account
import com.synth.password.repository.AccountRepository
import java.security.MessageDigest

class AccountViewModel : ViewModel() {
    private val accountRepository = AccountRepository()


    fun saveAccountData(newAccount: Account) {
        newAccount.password = encryptPassword(newAccount.password)
        accountRepository.saveAccountData(newAccount)
    }

    private fun encryptPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}

fun encryptPassword(password: String): String {
    val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
    return bytes.joinToString("") { "%02x".format(it) }
}