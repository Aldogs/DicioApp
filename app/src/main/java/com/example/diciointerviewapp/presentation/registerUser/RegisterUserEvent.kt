package com.example.diciointerviewapp.presentation.registerUser

sealed class RegisterUserEvent {
    data class NombreChanged(val nombre : String) : RegisterUserEvent()
    data class ApellidoPaternoChanged(val apellidoPaterno : String) : RegisterUserEvent()
    data class ApellidoMaternoChanged(val apellidoMaterno : String) : RegisterUserEvent()
    data class EmailChanged(val email : String) : RegisterUserEvent()
    data class FechaNacChanged(val fechaNac : String) : RegisterUserEvent()
    data class CalleChanged(val calle : String) : RegisterUserEvent()
    data class NumeroChanged(val numero : String) : RegisterUserEvent()
    data class ColoniaChanged(val colonia : String) : RegisterUserEvent()
    data class DelegacionChanged(val delegacion : String) : RegisterUserEvent()
    data class EstadoChanged(val estado : String) : RegisterUserEvent()
    data class CPChanged(val cp : String) : RegisterUserEvent()

    object Submit : RegisterUserEvent()
}