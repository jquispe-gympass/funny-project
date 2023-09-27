package com.example.funnyproject.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyproject.data.LocalLoginRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val loginRepository = LocalLoginRepository()

    private val _state = MutableStateFlow(LoginState.InitialState)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect = _effect.asSharedFlow()

    // Please read about the difference between StateFlows and SharedFlows
    // https://developer.android.com/kotlin/flow/stateflow-and-sharedflow


    fun login(email: String, password: String) {
        viewModelScope.launch {

        }
    }
}