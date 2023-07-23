package com.example.diciointerviewapp.presentation.registerUser

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RegisterUserScreen(
    navController: NavController
){
    val viewModel = viewModel<RegisterUserViewModel>()
    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is RegisterUserViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "Se ha registrado el usuario correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    TopAppBar(
        title = { Text(text = "Registro de usuario") },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(Icons.Rounded.ArrowBack, "")
            }
        },
        backgroundColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .padding(bottom = 40.dp)
    )
    Column(
        modifier = Modifier
            .padding(vertical = 100.dp, horizontal = 32.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.nombre,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.NombreChanged(it))
            },
            isError = state.nombreError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Nombre")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.nombreError != null) {
            Text(
                text = state.nombreError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.apellidoPaterno,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.ApellidoPaternoChanged(it))
            },
            isError = state.apellidoPaternoError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Apellido paterno")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.apellidoPaternoError != null) {
            Text(
                text = state.apellidoPaternoError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.apellidoMaterno,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.ApellidoMaternoChanged(it))
            },
            isError = state.apellidoMaternoError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Apellido materno")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.apellidoMaternoError != null) {
            Text(
                text = state.apellidoMaternoError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.email,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.EmailChanged(it))
            },
            isError = state.emailError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        if (state.emailError != null) {
            Text(
                text = state.emailError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.fechaNac,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.FechaNacChanged(it))
            },
            isError = state.fechaNacError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Fecha de nacimiendo")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.fechaNacError != null) {
            Text(
                text = state.fechaNacError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.calle,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.CalleChanged(it))
            },
            isError = state.calleError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Calle")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.calleError != null) {
            Text(
                text = state.calleError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.numero,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.NumeroChanged(it))
            },
            isError = state.numeroError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Número")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.numeroError != null) {
            Text(
                text = state.numeroError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.colonia,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.ColoniaChanged(it))
            },
            isError = state.coloniaError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Colonia")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.coloniaError != null) {
            Text(
                text = state.coloniaError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.delegacion,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.DelegacionChanged(it))
            },
            isError = state.delegacionError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Delegación")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.delegacionError != null) {
            Text(
                text = state.delegacionError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.estado,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.EstadoChanged(it))
            },
            isError = state.estadoError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Estado")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.estadoError != null) {
            Text(
                text = state.estadoError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.cp,
            onValueChange = {
                viewModel.onEvent(RegisterUserEvent.CPChanged(it))
            },
            isError = state.cpError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Código Postal")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        if (state.cpError != null) {
            Text(
                text = state.cpError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            onClick = {
                viewModel.onEvent(RegisterUserEvent.Submit)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Crear usuario")
        }
    }
}