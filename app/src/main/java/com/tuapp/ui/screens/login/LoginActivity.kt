// Pantalla de inicio de sesión de AlpaChange
package com.tuapp.ui.screens.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tuapp.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputCorreo: EditText
    private lateinit var inputPassword: EditText
    private lateinit var botonIngresar: Button
    private lateinit var botonCrearCuenta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Vincular vistas del layout
        inputCorreo = findViewById(R.id.input_correo)
        inputPassword = findViewById(R.id.input_password)
        botonIngresar = findViewById(R.id.boton_ingresar)
        botonCrearCuenta = findViewById(R.id.boton_crear_cuenta)

        // Manejo centralizado de clics (Clase 4)
        botonIngresar.setOnClickListener(this)
        botonCrearCuenta.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.boton_ingresar -> intentarIngresar()
            R.id.boton_crear_cuenta -> irARegistro()
        }
    }

    private fun intentarIngresar() {
        val correo = inputCorreo.text.toString().trim()
        val password = inputPassword.text.toString().trim()

        // Validación 1: campos vacíos
        if (correo.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this,
                getString(R.string.login_error_campos_vacios),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Validación 2: correo institucional UNTELS
        if (!correo.endsWith("@untels.edu.pe")) {
            Toast.makeText(
                this,
                getString(R.string.login_error_correo_invalido),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Validaciones OK
        Toast.makeText(
            this,
            getString(R.string.login_bienvenido) + ", " + correo,
            Toast.LENGTH_SHORT
        ).show()

        // TODO [Siguiente pantalla]: Navegar a HomeActivity con Intent explícito
        //  cuando construyamos la pantalla Home (lista de peticiones).
        // val intent = Intent(this, HomeActivity::class.java)
        // intent.putExtra("correo", correo)
        // startActivity(intent)
    }

    private fun irARegistro() {
        Toast.makeText(
            this,
            getString(R.string.login_ir_registro),
            Toast.LENGTH_SHORT
        ).show()

        // TODO [Siguiente pantalla]: Navegar a RegistroActivity con Intent explícito
        //  cuando construyamos la pantalla de Registro.
        // startActivity(Intent(this, RegistroActivity::class.java))
    }
}