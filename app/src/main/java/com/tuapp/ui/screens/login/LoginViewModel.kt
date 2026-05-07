// ViewModel encargado de la lógica de autenticación y validación del login.
package com.tuapp.ui.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState

    // Expresión regular: 10 dígitos seguidos de @untels.edu.pe
    private val emailRegex = Regex("^[0-9]{10}@untels\\.edu\\.pe$")

    /**
     * Valida las credenciales del usuario y actualiza el estado del login.
     */
    fun attemptLogin(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _loginState.value = LoginState.Error("CAMPOS_VACIOS")
            return
        }

        if (!emailRegex.matches(email)) {
            _loginState.value = LoginState.Error("CORREO_INVALIDO")
            return
        }

        // Simulación de éxito por ahora (mock)
        _loginState.value = LoginState.Success(email)
    }
}

/**
 * Representa los diferentes estados posibles de la pantalla de login.
 */
sealed class LoginState {
    data class Success(val email: String) : LoginState()
    data class Error(val code: String) : LoginState()
    object Loading : LoginState()
}
