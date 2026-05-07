// Repositorio encargado de gestionar los datos de las peticiones colectivas.
package com.tuapp.data.repository

import com.tuapp.data.model.Petition
import com.tuapp.data.model.PetitionStatus
import java.util.Calendar
import java.util.Date

class PetitionRepository {

    /**
     * Obtiene una lista de peticiones de prueba (mock) para la visualización inicial.
     */
    fun getPetitions(): List<Petition> {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 8)
        val expirationDate = calendar.time

        return listOf(
            Petition(
                id = "1",
                title = "Mejorar la conexión Wi-Fi en el pabellón A",
                description = "La señal de Wi-Fi es casi nula en los pisos superiores del pabellón A, dificultando las investigaciones en clase.",
                authorAlias = "EstudianteUNTELS",
                category = "Infraestructura",
                votesCount = 156,
                expiresAt = expirationDate,
                status = PetitionStatus.ACTIVA
            ),
            Petition(
                id = "2",
                title = "Ampliación del horario del comedor universitario",
                description = "Solicitamos que el comedor atienda hasta las 3 PM para los alumnos que salen tarde de laboratorios.",
                authorAlias = "LoboUntelsino",
                category = "Bienestar",
                votesCount = 89,
                expiresAt = expirationDate,
                status = PetitionStatus.ACTIVA
            ),
            Petition(
                id = "3",
                title = "Actualización de equipos en el laboratorio de cómputo",
                description = "Los equipos actuales tienen más de 5 años y no corren el software necesario para ingeniería.",
                authorAlias = "IngenieroPro",
                category = "Académico",
                votesCount = 312,
                expiresAt = expirationDate,
                status = PetitionStatus.RESUELTA,
                followUpNotes = "La universidad ha iniciado la compra de 40 nuevas computadoras i7."
            )
        )
    }

    /**
     * Busca una petición específica por su identificador único.
     */
    fun getPetitionById(id: String): Petition? {
        return getPetitions().find { it.id == id }
    }
}
