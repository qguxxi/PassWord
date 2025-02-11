package com.synth.password.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synth.password.data.local.Account
import com.synth.password.repository.AccountRepository
import com.synth.password.repository.UserRepository
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

class AccountViewModel(
    private val userRepository: UserRepository,
    private val accountRepo: AccountRepository
) : ViewModel() {

    suspend fun saveAccountData(newAccount: Account) {
        newAccount.password = encryptPassword(newAccount.password)
        accountRepo.saveAccountData(account = newAccount)
    }

    suspend fun getUserId(gmail: String, password: String): Int {
        return userRepository.getUserId(gmail, password)!!
    }

    private fun decryptPassword(encryptedPassword: String): String {
        // Assuming you have a method to get the secret key
        val secretKey = getSecretKey()
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val decodedBytes =
            android.util.Base64.decode(encryptedPassword, android.util.Base64.DEFAULT)
        val decryptedBytes = cipher.doFinal(decodedBytes)
        return String(decryptedBytes)
    }

    private fun getSecretKey(): SecretKey {
        // Replace with your method to retrieve the secret key
        val keyBytes = ByteArray(16) // Example key, replace with your actual key
        return SecretKeySpec(keyBytes, "AES")
    }

    private fun encryptPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    private val accountRepository = AccountRepository()
    private val _accountData = MutableLiveData<Account?>()
    val accountData: LiveData<Account?> get() = _accountData

    init {
        val id = 0
        fetchAccountData(id.toString())
    }
    fun fetchAccountData(accountId: String) {
        accountRepository.getAccountData(accountId) { account ->
            _accountData.value = account
        }
    }



}