// Repositorio encargado de gestionar los datos de los docentes y sus reseñas.
package com.tuapp.data.repository

import com.tuapp.data.model.Professor

class ProfessorRepository {

    /**
     * Obtiene una lista de docentes de prueba (mock) con sus calificaciones promediadas.
     */
    fun getProfessors(): List<Professor> {
        return listOf(
            Professor(
                id = "p1",
                firstName = "Juan",
                lastName = "Pérez",
                department = "Ingeniería de Sistemas",
                averageRating = 4.5f,
                reviewsCount = 12,
                ratingTeaching = 4.8f,
                ratingPunctuality = 4.0f,
                ratingRespect = 4.5f,
                ratingKnowledge = 4.7f
            ),
            Professor(
                id = "p2",
                firstName = "María",
                lastName = "García",
                department = "Electrónica y Telecomunicaciones",
                averageRating = 3.8f,
                reviewsCount = 8,
                ratingTeaching = 3.5f,
                ratingPunctuality = 4.5f,
                ratingRespect = 4.0f,
                ratingKnowledge = 3.2f
            ),
            Professor(
                id = "p3",
                firstName = "Carlos",
                lastName = "Sánchez",
                department = "Ingeniería Mecánica",
                averageRating = 4.2f,
                reviewsCount = 20,
                ratingTeaching = 4.0f,
                ratingPunctuality = 3.8f,
                ratingRespect = 4.5f,
                ratingKnowledge = 4.5f
            )
        )
    }

    /**
     * Busca un docente específico por su identificador único.
     */
    fun getProfessorById(id: String): Professor? {
        return getProfessors().find { it.id == id }
    }
}
