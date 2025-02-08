package com.synth.password.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.synth.password.repository.UserRepository

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    
}