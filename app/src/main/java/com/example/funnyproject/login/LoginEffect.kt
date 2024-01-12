package com.example.funnyproject.login

sealed class LoginEffect {

    object Fail: LoginEffect()
    object Success: LoginEffect()
    object Initial: LoginEffect()
}
