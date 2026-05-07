// ViewModel que gestiona la lógica de registro de nuevos usuarios.
package com.tuapp.ui.screens.registro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistroViewModel : ViewModel() {

    private val _registerState = MutableLiveData<RegisterState>()
    val registerState: LiveData<RegisterState> = _registerState

    // Expresión regular: 10 dígitos seguidos de @untels.edu.pe
    private val emailRegex = Regex("^[0-9]{10}@untels\\.edu\\.pe$")

    /**
     * Valida los datos del formulario y procesa la creación de la cuenta.
     */
    fun register(email: String, pass: String, confirmPass: String) {
        if (email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            _registerState.value = RegisterState.Error("CAMPOS_VACIOS")
            return
        }

        if (!emailRegex.matches(email)) {
            _registerState.value = RegisterState.Error("CORREO_INVALIDO")
            return
        }

        if (pass != confirmPass) {
            _registerState.value = RegisterState.Error("PASSWORD_NO_COINCIDE")
            return
        }

        // Extraer código de estudiante automáticamente
        val studentCode = email.split("@")[0]
        
        // Simulación de registro exitoso (mock)
        _registerState.value = RegisterState.Success(studentCode)
    }
}

/**
 * Representa los estados del proceso de registro.
 */
sealed class RegisterState {
    data class Success(val studentCode: String) : RegisterState()
    data class Error(val code: String) : RegisterState()
    object Loading : RegisterState()
}
