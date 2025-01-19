package com.synth.password.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_accounts_table WHERE gmail = :gmail AND password = :password")
    suspend fun loginUser(gmail: String, password: String): User?
}
