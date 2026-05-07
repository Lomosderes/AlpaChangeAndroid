// Clase que representa una petición colectiva creada por un estudiante.
package com.tuapp.data.model

import java.util.Date

data class Petition(
    val id: String,
    val title: String,          // Máximo 200 caracteres
    val description: String,
    val authorAlias: String,
    val category: String? = null,
    val votesCount: Int = 0,
    val createdAt: Date = Date(),
    val expiresAt: Date,        // Inicialmente 8 días después de creación
    val status: PetitionStatus = PetitionStatus.ACTIVA,
    val followUpNotes: String? = null,
    val pdfUrl: String? = null
)

enum class PetitionStatus {
    ACTIVA,
    EXTENDIDA,
    ARCHIVADA,
    RESUELTA
}
