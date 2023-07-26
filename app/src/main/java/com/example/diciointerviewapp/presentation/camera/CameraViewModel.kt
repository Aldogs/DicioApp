package com.example.diciointerviewapp.presentation.camera

import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.ByteArrayOutputStream


class CameraViewModel : ViewModel() {

    private val _state = MutableStateFlow(CameraState())
    val state = _state.asStateFlow()

    fun onPhotoCaptured(bitmap: Bitmap) {
        // Se recorta la imagen
        val cropped : Bitmap  = Bitmap.createBitmap(bitmap, 0, bitmap.height /2 - bitmap.width /2, 300, 300)

        val outputStream = ByteArrayOutputStream()
        cropped.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val byteArray = outputStream.toByteArray()

        // Se consigue el base64 de la imagen
        val encodedString: String = Base64.encodeToString(byteArray, Base64.DEFAULT)
        Log.d("base64", "La base64 de la foto es: $encodedString")

        updateCapturedPhotoState(bitmap, encodedString)
    }

    fun onCapturedPhotoConsumed() {
        updateCapturedPhotoState(null, null)
    }

    private fun updateCapturedPhotoState(updatedPhoto: Bitmap?, encodedString: String?) {
        _state.value.capturedImage?.recycle()
        _state.value = _state.value.copy(capturedImage = updatedPhoto)
        _state.value = _state.value.copy(base64 = encodedString)
    }

    override fun onCleared() {
        _state.value.capturedImage?.recycle()
        super.onCleared()
    }
}
