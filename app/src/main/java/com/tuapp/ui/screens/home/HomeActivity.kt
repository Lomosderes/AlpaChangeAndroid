// Activity que gestiona la vista de la lista de peticiones (Home).
package com.tuapp.ui.screens.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuapp.R
import com.tuapp.ui.components.PetitionAdapter

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: PetitionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupRecyclerView()
        observeViewModel()

        viewModel.loadPetitions()
    }

    /**
     * Configura el RecyclerView con su LayoutManager y el adaptador de peticiones.
     */
    private fun setupRecyclerView() {
        val rvPetitions = findViewById<RecyclerView>(R.id.rvPetitions)
        adapter = PetitionAdapter(emptyList())
        rvPetitions.layoutManager = LinearLayoutManager(this)
        rvPetitions.adapter = adapter
    }

    /**
     * Suscribe la vista a los cambios en el LiveData del ViewModel para actualizar la lista.
     */
    private fun observeViewModel() {
        viewModel.petitions.observe(this) { petitions ->
            adapter.updateData(petitions)
        }
    }
}
