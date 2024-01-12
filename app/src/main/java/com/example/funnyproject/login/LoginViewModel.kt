package com.example.funnyproject.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyproject.domain.LoginUserUseCase
import com.example.funnyproject.domain.ValidateUserCredentialsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    val validateUserCredentialsUseCase: ValidateUserCredentialsUseCase,
    val loginUserUseCase: LoginUserUseCase
): ViewModel() {

    private val _state = MutableStateFlow(LoginState.InitialState)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect = _effect.asSharedFlow()

    // Please read about the difference between StateFlows and SharedFlows
    // https://developer.android.com/kotlin/flow/stateflow-and-sharedflow

    fun onEvent(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.OnLoginAction -> login(loginEvent.email, loginEvent.password)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            if (validateUserCredentialsUseCase(email, password) && loginUserUseCase(email, password)) {
                _effect.emit(LoginEffect.Success)
            } else {
                _effect.emit(LoginEffect.Fail)
            }
        }
    }
}