package com.example.diciointerviewapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diciointerviewapp.presentation.home.HomeScreen
import com.example.diciointerviewapp.presentation.registerUser.RegisterUserScreen
import com.example.diciointerviewapp.ui.theme.DicioInterviewAppTheme
import com.example.diciointerviewapp.presentation.userList.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DicioInterviewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home_screen"
                    ) {
                        composable("home_screen") {
                            HomeScreen(navController = navController)
                        }
                        composable("user_list_screen") {
                            UserListScreen(navController = navController)
                        }
                        composable("register_user_screen") {
                            RegisterUserScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
