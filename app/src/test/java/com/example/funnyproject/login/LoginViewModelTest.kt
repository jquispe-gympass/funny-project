package com.example.funnyproject.login

import app.cash.turbine.test
import com.example.funnyproject.data.LocalLoginRepository
import com.example.funnyproject.domain.LoginUserUseCase
import com.example.funnyproject.domain.ValidateUserCredentialsUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    // First of all, read about coroutines. Please READ it thoroughly. Its the start of everything.
    // https://developer.android.com/kotlin/coroutines
    // https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-test#using-in-your-project

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val loginViewModel = LoginViewModel(
        ValidateUserCredentialsUseCase(),
        LoginUserUseCase(LocalLoginRepository())
    )

    @Test
    fun `After a failed login attempt, effect should be fail`() = runTest {
        loginViewModel.effect.test {
            // Read about Turbine: https://github.com/cashapp/turbine
            loginViewModel.login("", "")
        }
    }

    @Test
    fun `After a successful login attempt, effect should be success`() = runTest {
        loginViewModel.effect.test {
            // Read about Turbine: https://github.com/cashapp/turbine
            loginViewModel.login("tiago@gmail.com", "12345678")
            assert(awaitItem() is LoginEffect.Success)
        }
    }
}
