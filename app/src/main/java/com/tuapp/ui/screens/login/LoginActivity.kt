// Activity que gestiona la interacción del usuario con la pantalla de login.
package com.tuapp.ui.screens.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tuapp.R
import com.tuapp.ui.screens.home.HomeActivity
import com.tuapp.ui.screens.registro.RegistroActivity

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupListeners()
        observeViewModel()
    }

    /**
     * Configura los eventos de clic de los botones de la pantalla.
     */
    private fun setupListeners() {
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            viewModel.attemptLogin(email, password)
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }
    }

    /**
     * Suscribe la vista a los cambios de estado en el ViewModel.
     */
    private fun observeViewModel() {
        viewModel.loginState.observe(this) { state ->
            when (state) {
                is LoginState.Success -> {
                    Toast.makeText(this, getString(R.string.login_welcome), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
                is LoginState.Error -> {
                    handleError(state.code)
                }
                is LoginState.Loading -> {
                    // Implementar spinner si es necesario
                }
            }
        }
    }

    /**
     * Gestiona la visualización de errores según el código recibido del ViewModel.
     */
    private fun handleError(code: String) {
        val message = when (code) {
            "CAMPOS_VACIOS" -> getString(R.string.login_error_empty)
            "CORREO_INVALIDO" -> getString(R.string.login_error_invalid_email)
            else -> "Error desconocido"
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
