// Pantalla principal (Home) de AlpaChange con peticiones destacadas
package com.tuapp.ui.screens.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tuapp.R
import com.tuapp.ui.screens.profesores.ListaProfesoresActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textCorreoUsuario: TextView
    private lateinit var botonVerDocentes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Vincular vistas
        textCorreoUsuario = findViewById(R.id.text_correo_usuario)
        botonVerDocentes = findViewById(R.id.boton_ver_docentes)

        // Recuperar el correo enviado desde LoginActivity con putExtra.
        // Si por alguna razón no llega el extra, mostramos aviso y volvemos al login
        // en lugar de continuar con un valor vacío que confunda al usuario.
        val correo = intent.getStringExtra(getString(R.string.extra_correo))
        if (correo.isNullOrBlank()) {
            Toast.makeText(this, getString(R.string.login_error_campos_vacios), Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        textCorreoUsuario.text = correo

        // Manejo centralizado de clics
        botonVerDocentes.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.boton_ver_docentes -> irAListaDocentes()
        }
    }

    private fun irAListaDocentes() {
        startActivity(Intent(this, ListaProfesoresActivity::class.java))
    }
}