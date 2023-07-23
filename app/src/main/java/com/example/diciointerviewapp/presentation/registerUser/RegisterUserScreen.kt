package com.example.diciointerviewapp.presentation.registerUser

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RegisterUserScreen(
    navController: NavController
){
    Column {
        TopAppBar(
            title = { Text(text = "Registro de usuario") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Rounded.ArrowBack, "")
                }
            },
            backgroundColor = MaterialTheme.colors.onPrimary
        )

    }
}