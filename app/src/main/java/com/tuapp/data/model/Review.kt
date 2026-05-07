// Clase que representa una reseña escrita por un estudiante sobre un profesor.
package com.tuapp.data.model

import java.util.Date

data class Review(
    val id: String,
    val professorId: String,
    val userId: String,
    val courseName: String,
    val comment: String,
    val ratingTeaching: Int,    // 1-5
    val ratingPunctuality: Int, // 1-5
    val ratingRespect: Int,     // 1-5
    val ratingKnowledge: Int,   // 1-5
    val isAnonymous: Boolean = false,
    val userAlias: String? = null,
    val createdAt: Date = Date()
)
