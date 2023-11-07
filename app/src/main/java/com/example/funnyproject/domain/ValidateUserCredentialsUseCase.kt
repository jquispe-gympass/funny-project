package com.example.funnyproject.domain

class ValidateUserCredentialsUseCase {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return email.contains("@") && password.length > MINIM_PASSWORD_CHARS
    }
}

private const val MINIM_PASSWORD_CHARS = 8
