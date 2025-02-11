package com.synth.password.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.synth.password.repository.AccountRepository
import com.synth.password.repository.UserRepository

class HomeViewModel(
    private val accountRepository: AccountRepository
) : ViewModel() {
     fun getAccountData() {

     }
}