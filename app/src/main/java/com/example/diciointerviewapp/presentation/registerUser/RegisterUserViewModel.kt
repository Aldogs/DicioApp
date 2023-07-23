package com.example.diciointerviewapp.presentation.registerUser

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diciointerviewapp.domain.use_cases.ValidateEmail
import com.example.diciointerviewapp.domain.use_cases.ValidateFechaNac
import com.example.diciointerviewapp.domain.use_cases.ValidateInt
import com.example.diciointerviewapp.domain.use_cases.ValidateNotEmpty
import com.example.diciointerviewapp.domain.use_cases.ValidateString
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterUserViewModel(
    private val validateNombre : ValidateString = ValidateString(),
    private val validateApellidoPaterno : ValidateString = ValidateString(),
    private val validateApellidoMaterno : ValidateString = ValidateString(),
    private val validateEmail : ValidateEmail = ValidateEmail(),
    private val validateFechaNac : ValidateFechaNac = ValidateFechaNac(),
    private val validateCalle : ValidateString = ValidateString(),
    private val validateNumero : ValidateInt = ValidateInt(),
    private val validateColonia : ValidateNotEmpty = ValidateNotEmpty(),
    private val validateDelegacion : ValidateString = ValidateString(),
    private val validateEstado : ValidateString = ValidateString(),
    private val validateCP : ValidateInt = ValidateInt(),
    ) : ViewModel() {

    var state by mutableStateOf(RegisterUserState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegisterUserEvent) {
        when(event) {
            is RegisterUserEvent.NombreChanged -> {
                state = state.copy(nombre = event.nombre)
            }
            is RegisterUserEvent.ApellidoPaternoChanged -> {
                state = state.copy(apellidoPaterno = event.apellidoPaterno)
            }
            is RegisterUserEvent.ApellidoMaternoChanged -> {
                state = state.copy(apellidoMaterno = event.apellidoMaterno)
            }
            is RegisterUserEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegisterUserEvent.FechaNacChanged -> {
                state = state.copy(fechaNac = event.fechaNac)
            }
            is RegisterUserEvent.CalleChanged -> {
                state = state.copy(calle = event.calle)
            }
            is RegisterUserEvent.NumeroChanged -> {
                state = state.copy(numero = event.numero)
            }
            is RegisterUserEvent.ColoniaChanged -> {
                state = state.copy(colonia = event.colonia)
            }
            is RegisterUserEvent.EstadoChanged -> {
                state = state.copy(estado = event.estado)
            }
            is RegisterUserEvent.DelegacionChanged -> {
                state = state.copy(delegacion = event.delegacion)
            }
            is RegisterUserEvent.CPChanged -> {
                state = state.copy(cp = event.cp)
            }
            is RegisterUserEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val nombreResult = validateNombre.execute(state.nombre)
        val apellidoPaternoResult = validateApellidoPaterno.execute(state.apellidoPaterno)
        val apellidoMaternoResult = validateApellidoMaterno.execute(state.apellidoMaterno)
        val emailResult = validateEmail.execute(state.email)
        val fechaNacResult = validateFechaNac.execute(state.fechaNac)
        val calleResult = validateCalle.execute(state.calle)
        val numeroResult = validateNumero.execute(state.numero)
        val coloniaResult = validateColonia.execute(state.colonia)
        val delegacionResult = validateDelegacion.execute(state.delegacion)
        val estadoResult = validateEstado.execute(state.estado)
        val cpResult = validateCP.execute(state.cp)

        val hasError = listOf(
            nombreResult,
            apellidoPaternoResult,
            apellidoMaternoResult,
            emailResult,
            fechaNacResult,
            calleResult,
            numeroResult,
            coloniaResult,
            delegacionResult,
            estadoResult,
            cpResult,
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                nombreError = nombreResult.errorMessage,
                apellidoPaternoError = apellidoPaternoResult.errorMessage,
                apellidoMaternoError = apellidoMaternoResult.errorMessage,
                emailError = emailResult.errorMessage,
                fechaNacError = fechaNacResult.errorMessage,
                calleError = calleResult.errorMessage,
                numeroError = numeroResult.errorMessage,
                coloniaError = coloniaResult.errorMessage,
                delegacionError = delegacionResult.errorMessage,
                estadoError = estadoResult.errorMessage,
                cpError = cpResult.errorMessage

            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}