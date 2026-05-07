// Clase que representa a un usuario de la plataforma AlpaChange.
package com.tuapp.data.model

data class User(
    val id: String,
    val studentCode: String, // 10 dígitos extraídos del correo
    val email: String,       // Formato @untels.edu.pe
    val firstName: String? = null,
    val lastName: String? = null,
    val alias: String? = null,
    val isVerified: Boolean = false,
    val showRealName: Boolean = false,
    val showMyPetitions: Boolean = true,
    val role: UserRole = UserRole.ESTUDIANTE
)

enum class UserRole {
    VISITANTE,
    ESTUDIANTE,
    STAFF
}
