// ViewModel para la pantalla de Home que gestiona la lista de peticiones.
package com.tuapp.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuapp.data.model.Petition
import com.tuapp.data.repository.PetitionRepository

class HomeViewModel : ViewModel() {

    private val repository = PetitionRepository()
    private val _petitions = MutableLiveData<List<Petition>>()
    val petitions: LiveData<List<Petition>> = _petitions

    /**
     * Carga la lista de peticiones desde el repositorio y actualiza el LiveData.
     */
    fun loadPetitions() {
        _petitions.value = repository.getPetitions()
    }
}
