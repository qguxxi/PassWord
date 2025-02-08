package com.synth.password.data.local


data class Card (
    val idAccount : Int,
    val title: String,
    val nameBank: String,
    val password: String,
    val accountNumber: Int,
    val date: String,
    val securityNumber: Int
)