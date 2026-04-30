// Pantalla con la lista de docentes destacados de AlpaChange
package com.tuapp.ui.screens.profesores

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tuapp.R

class ListaProfesoresActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    // Lista estática de docentes (Sección 6, Regla 5: datos como List<String> en la Activity
    // mientras no se hayan visto Repository / BD / API en clase)
    private val profesores = listOf(
        "Dr. Juan Pérez — Ingeniería de Sistemas",
        "Dra. María López — Electrónica y Telecomunicaciones",
        "Mg. Carlos Ramírez — Mecatrónica",
        "Lic. Ana Torres — Matemática",
        "Dr. Luis Salazar — Ingeniería Industrial",
        "Mg. Patricia Quispe — Administración",
        "Dr. Roberto Fernández — Ciencias de la Computación",
        "Mg. Jorge Mendoza — Física Aplicada"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_profesores)

        listView = findViewById(R.id.list_profesores)

        // Adaptador con layout de ítem personalizado (Clase 4)
        val adapter = ArrayAdapter(
            this,
            R.layout.item_profesor,
            R.id.text_profesor,
            profesores
        )
        listView.adapter = adapter

        // Click en un ítem de la lista
        listView.setOnItemClickListener { _, _, position, _ ->
            val profesorSeleccionado = profesores[position]
            Toast.makeText(
                this,
                getString(R.string.lista_profesores_seleccionado) + " " + profesorSeleccionado,
                Toast.LENGTH_SHORT
            ).show()

            // TODO [Siguiente pantalla]: Navegar a DetalleProfesorActivity con Intent explícito
            //  pasando el dato con putExtra cuando construyamos la pantalla de detalle.
            // val intent = Intent(this, DetalleProfesorActivity::class.java)
            // intent.putExtra(getString(R.string.extra_profesor), profesorSeleccionado)
            // startActivity(intent)
        }
    }
}