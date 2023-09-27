package com.example.funnyproject.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel()) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Implement a Login Screen")
    }
}