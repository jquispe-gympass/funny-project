package com.example.funnyproject.data

interface LoginRepository {

    suspend fun loginUser(email: String, password: String): Boolean
}