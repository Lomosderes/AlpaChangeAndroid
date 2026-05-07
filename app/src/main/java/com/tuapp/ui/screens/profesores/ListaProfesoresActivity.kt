// Activity que visualiza el directorio de profesores de la UNTELS.
package com.tuapp.ui.screens.profesores

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuapp.R
import com.tuapp.ui.components.ProfessorAdapter

class ListaProfesoresActivity : AppCompatActivity() {

    private val viewModel: ListaProfesoresViewModel by viewModels()
    private lateinit var adapter: ProfessorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_profesores)

        setupRecyclerView()
        setupSearch()
        observeViewModel()

        viewModel.loadProfessors()
    }

    /**
     * Inicializa el RecyclerView con el adaptador de profesores.
     */
    private fun setupRecyclerView() {
        val rvProfessors = findViewById<RecyclerView>(R.id.rvProfessors)
        adapter = ProfessorAdapter(emptyList())
        rvProfessors.layoutManager = LinearLayoutManager(this)
        rvProfessors.adapter = adapter
    }

    /**
     * Configura la lógica de búsqueda en tiempo real mediante el EditText.
     */
    private fun setupSearch() {
        val etSearch = findViewById<EditText>(R.id.etSearchProfessor)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.filterProfessors(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    /**
     * Suscribe la UI a los cambios en el listado de profesores del ViewModel.
     */
    private fun observeViewModel() {
        viewModel.professors.observe(this) { professors ->
            adapter.updateData(professors)
        }
    }
}
