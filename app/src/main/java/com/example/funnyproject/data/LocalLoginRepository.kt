package com.example.funnyproject.data

import kotlinx.coroutines.delay

class LocalLoginRepository: LoginRepository {

    override suspend fun loginUser(email: String, password: String): Boolean {
        delay(2_000)
        return true
    }
}
