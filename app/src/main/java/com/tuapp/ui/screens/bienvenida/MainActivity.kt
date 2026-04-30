// Pantalla de bienvenida (splash) de AlpaChange
package com.tuapp.ui.screens.bienvenida

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.tuapp.R
import com.tuapp.ui.screens.login.LoginActivity

class MainActivity : AppCompatActivity() {

    // Tiempo de espera del splash en milisegundos
    private val tiempoSplashMs: Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Splash temporizado: tras unos segundos, navegar a LoginActivity con Intent explícito
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // evita que el usuario vuelva al splash con el botón Atrás
        }, tiempoSplashMs)
    }
}