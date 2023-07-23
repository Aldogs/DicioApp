package com.example.diciointerviewapp.remote.responses

data class User(
    val apellidoMaterno: String,
    val apellidoPaterno: String,
    val datos: Datos,
    val edad: Int,
    val email: String,
    val fechaNac: String,
    val id: Int,
    val nombre: String
)