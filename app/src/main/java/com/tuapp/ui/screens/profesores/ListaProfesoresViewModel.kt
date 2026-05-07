// ViewModel encargado de gestionar la lógica de la lista de profesores y sus filtros.
package com.tuapp.ui.screens.profesores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuapp.data.model.Professor
import com.tuapp.data.repository.ProfessorRepository

class ListaProfesoresViewModel : ViewModel() {

    private val repository = ProfessorRepository()
    private val _professors = MutableLiveData<List<Professor>>()
    val professors: LiveData<List<Professor>> = _professors

    /**
     * Carga la lista inicial de profesores desde el repositorio.
     */
    fun loadProfessors() {
        _professors.value = repository.getProfessors()
    }

    /**
     * Filtra la lista de profesores según un criterio de búsqueda por nombre.
     */
    fun filterProfessors(query: String) {
        val all = repository.getProfessors()
        if (query.isEmpty()) {
            _professors.value = all
        } else {
            _professors.value = all.filter { 
                it.firstName.contains(query, ignoreCase = true) || 
                it.lastName.contains(query, ignoreCase = true) 
            }
        }
    }
}
