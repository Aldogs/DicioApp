package com.example.diciointerviewapp.presentation.camera

import android.graphics.Bitmap

data class CameraState(
    val capturedImage: Bitmap? = null,
    var base64: String? = null
)
