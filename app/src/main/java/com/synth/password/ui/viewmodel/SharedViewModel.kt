package com.synth.password.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _gmail = MutableLiveData<String>()
    val gmail: LiveData<String> get() = _gmail

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    fun setUserData(gmail: String, password: String) {
        _gmail.value = gmail
        _password.value = password
    }
}
