// Clase que representa a un docente de la UNTELS y sus estadísticas de evaluación.
package com.tuapp.data.model

data class Professor(
    val id: String,
    val firstName: String,
    val lastName: String,
    val department: String,
    val averageRating: Float = 0f,
    val reviewsCount: Int = 0,
    // Promedios desglosados
    val ratingTeaching: Float = 0f,    // Enseñanza
    val ratingPunctuality: Float = 0f, // Puntualidad
    val ratingRespect: Float = 0f,     // Respeto
    val ratingKnowledge: Float = 0f    // Conocimiento
) {
    val fullName: String get() = "$firstName $lastName"
}
