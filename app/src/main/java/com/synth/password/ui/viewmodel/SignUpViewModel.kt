package com.synth.password.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.synth.password.data.local.User
import com.synth.password.repository.UserRepository
import kotlinx.coroutines.launch

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun registerUser(user: User) {
        try {
        viewModelScope.launch {
            userRepository.registerUser(user)
        }
    } catch (e : Exception) {
        e.printStackTrace()
    }}
}