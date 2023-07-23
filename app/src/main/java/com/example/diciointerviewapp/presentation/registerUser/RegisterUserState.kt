package com.example.diciointerviewapp.presentation.registerUser

data class RegisterUserState(
    val nombre: String = "",
    val nombreError: String? = null,
    val apellidoPaterno: String = "",
    val apellidoPaternoError: String? = null,
    val apellidoMaterno: String = "",
    val apellidoMaternoError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val fechaNac: String = "",
    val fechaNacError: String? = null,
    val calle: String = "",
    val calleError: String? = null,
    val numero: String = "",
    val numeroError: String? = null,
    val colonia: String = "",
    val coloniaError: String? = null,
    val delegacion: String = "",
    val delegacionError: String? = null,
    val estado: String = "",
    val estadoError: String? = null,
    val cp: String = "",
    val cpError: String? = null,
)
