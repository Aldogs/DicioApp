package com.example.diciointerviewapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diciointerviewapp.R

@Composable
fun HomeScreen(
    navController: NavController
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_dicio_foreground),
                contentDescription = "Dicio Logo",
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
            )
            ElevatedButton(
                onClick = {
                    navController.navigate("register_user_screen")
                }
            ) {
                androidx.compose.material3.Text(text = "Registrar usuario")
            }
            Spacer(modifier = Modifier.height(20.dp))
            ElevatedButton(
                onClick = {
                    navController.navigate("user_list_screen")
                }
            ) {
                androidx.compose.material3.Text(text = "Ver usuarios")
            }
        }
    }
}
