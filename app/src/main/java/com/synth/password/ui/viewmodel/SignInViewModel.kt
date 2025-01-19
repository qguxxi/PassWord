package com.synth.password.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.synth.password.repository.UserRepository

class SignInViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    suspend fun loginUser(gmail : String,password : String): Boolean {
        return userRepository.getUser(gmail,password) != null
    }
}