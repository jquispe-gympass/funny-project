package com.example.funnyproject.login

sealed interface LoginEvent {
    data class OnEmailChanged(val email: String): LoginEvent
    data class OnPasswordChanged(val password: String): LoginEvent
    object OnLoginAction: LoginEvent
}