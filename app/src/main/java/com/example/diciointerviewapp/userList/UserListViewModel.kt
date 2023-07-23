package com.example.diciointerviewapp.userList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diciointerviewapp.data.remote.responses.User
import com.example.diciointerviewapp.repository.UserRepository
import com.example.diciointerviewapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {
    var userList = mutableStateOf<List<Any?>>(listOf())
    var errorLoading = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun getUsers() {
        viewModelScope.launch {
            isLoading.value = true

            when (val result = repository.getUserList()) {
                is Resource.Error -> {
                    errorLoading.value = result.toString()
                    isLoading.value = false
                }
                is Resource.Success -> {

                    val userEntries = result.data?.results?.mapIndexed { _, entry ->
                        val nombre = entry.nombre
                        val apellidoPaterno = entry.apellidoPaterno
                        val apellidoMaterno = entry.apellidoMaterno
                        val edad = entry.edad
                        val email = entry.email
                        val fechaNac = entry.fechaNac
                        val datos = entry.datos
                        User(nombre, apellidoPaterno, apellidoMaterno, edad, email, fechaNac, datos)
                    }
                    errorLoading.value = ""
                    isLoading.value = false
                    userList.value += userEntries
                }

                else -> {}
            }
        }
    }
}