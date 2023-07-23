package com.example.diciointerviewapp.data.models

import com.example.diciointerviewapp.data.remote.responses.Datos
import com.example.diciointerviewapp.data.remote.responses.User

data class UserEntry(
    val nombre: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val edad: Int,
    val email: String,
    val fechaNac: String,
    val datos: Datos
)

data class UserList(
    val results: ArrayList<UserEntry>
    )