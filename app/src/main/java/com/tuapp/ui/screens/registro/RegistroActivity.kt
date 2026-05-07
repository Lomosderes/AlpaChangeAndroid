// Activity que gestiona la vista del formulario de registro.
package com.tuapp.ui.screens.registro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tuapp.R

class RegistroActivity : AppCompatActivity() {

    private val viewModel: RegistroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        setupListeners()
        observeViewModel()
    }

    /**
     * Configura el evento de clic para el botón de registro.
     */
    private fun setupListeners() {
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnSignup.setOnClickListener {
            viewModel.register(
                etEmail.text.toString(),
                etPassword.text.toString(),
                etConfirmPassword.text.toString()
            )
        }
    }

    /**
     * Suscribe la vista a los cambios de estado en el ViewModel de registro.
     */
    private fun observeViewModel() {
        viewModel.registerState.observe(this) { state ->
            when (state) {
                is RegisterState.Success -> {
                    Toast.makeText(this, getString(R.string.register_success), Toast.LENGTH_LONG).show()
                    finish() // Regresa al Login
                }
                is RegisterState.Error -> {
                    handleError(state.code)
                }
                is RegisterState.Loading -> {
                    // Mostrar progreso
                }
            }
        }
    }

    /**
     * Muestra mensajes de error específicos según el código devuelto por el ViewModel.
     */
    private fun handleError(code: String) {
        val message = when (code) {
            "CAMPOS_VACIOS" -> getString(R.string.login_error_empty)
            "CORREO_INVALIDO" -> getString(R.string.login_error_invalid_email)
            "PASSWORD_NO_COINCIDE" -> getString(R.string.register_error_passwords_dont_match)
            else -> "Error en el registro"
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
