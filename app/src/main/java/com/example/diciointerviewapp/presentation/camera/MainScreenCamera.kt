@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.diciointerviewapp.presentation.camera

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun MainScreenCamera(
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

        if (cameraPermissionState.status.isGranted) {
            CameraScreen()
        } else {
            NoPermissionScreen(cameraPermissionState::launchPermissionRequest)
        }
    }
}
