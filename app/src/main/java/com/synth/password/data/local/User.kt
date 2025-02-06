package com.synth.password.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_accounts_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val gmail: String,
    val password: String
)
