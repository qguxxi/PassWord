package com.synth.password.repository

import com.synth.password.data.local.User
import com.synth.password.data.local.UserDao

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUser(gmail: String, password: String): User? {
        return userDao.loginUser(gmail, password)
    }

}
