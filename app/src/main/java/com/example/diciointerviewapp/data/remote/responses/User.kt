package com.example.diciointerviewapp.data.remote.responses

data class User(
    val nombre: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val edad: Int,
    val email: String,
    val fechaNac: String,
    val datos: Datos,
)