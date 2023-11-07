package com.example.funnyproject.domain

import com.example.funnyproject.data.LoginRepository

class LoginUserUseCase(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(email: String, password: String) = loginRepository.loginUser(email, password)
}