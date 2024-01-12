package com.example.funnyproject.login

sealed class LoginState {

    object Loading: LoginState()
    object InitialState: LoginState()
}
