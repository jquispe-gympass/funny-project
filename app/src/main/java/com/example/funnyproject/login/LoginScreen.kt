package com.example.funnyproject.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.funnyproject.data.LocalLoginRepository
import com.example.funnyproject.domain.LoginUserUseCase
import com.example.funnyproject.domain.ValidateUserCredentialsUseCase
import com.example.funnyproject.extensions.collectAsEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        content = {
            val email = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }

            viewModel.effect.collectAsEffect { effect ->
                when (effect) {
                    LoginEffect.Initial -> TODO()
                    LoginEffect.Success -> TODO()
                    LoginEffect.Fail -> {
                        showSnackBar(
                            message = "Failed to Login",
                            coroutineScope = scope,
                            snackbarHostState = snackBarHostState
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = email.value,
                    onValueChange = { value -> email.value = value }
                )
                TextField(
                    value = password.value,
                    onValueChange = { value -> password.value = value }
                )
                Button(onClick = {
                    viewModel.onEvent(
                        LoginEvent.OnLoginAction(email.value.toString(), password.value.toString())
                    )
                }) {
                    Text("Login!")
                }
            }

        })
}

fun showSnackBar(
    message: String?,
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    message?.let {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(it)
        }
    }

}

@Composable
@Preview(showSystemUi = true)
private fun ShowScreen() {
    val loginViewModel = LoginViewModel(
        ValidateUserCredentialsUseCase(),
        LoginUserUseCase(LocalLoginRepository())
    )
    LoginScreen(
        loginViewModel
    )
}