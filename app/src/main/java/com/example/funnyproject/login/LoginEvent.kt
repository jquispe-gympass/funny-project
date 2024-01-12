package com.example.funnyproject.login

sealed interface LoginEvent {
    data class OnLoginAction(val email: String, val password: String): LoginEvent
}