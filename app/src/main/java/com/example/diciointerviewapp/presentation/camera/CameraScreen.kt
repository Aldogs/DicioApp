package com.example.diciointerviewapp.presentation.camera

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.diciointerviewapp.util.rotateBitmap


@Composable
fun CameraScreen(
    viewModel: CameraViewModel = viewModel()
) {

    val cameraState: CameraState by viewModel.state.collectAsStateWithLifecycle()

    CameraContent(
        onPhotoCaptured = viewModel::onPhotoCaptured
    )

    cameraState.capturedImage?.let { capturedImage: Bitmap ->
        CapturedImageBitmapDialog(
            capturedImage = capturedImage,
            onDismissRequest = viewModel::onCapturedPhotoConsumed
        )
    }

    cameraState.base64?.let { base64: String ->
        getBase64String(LocalContext.current, base64 = base64)
    }
}

@Composable
private fun CapturedImageBitmapDialog(
    capturedImage: Bitmap,
    onDismissRequest: () -> Unit
) {

    val capturedImageBitmap: ImageBitmap = remember { capturedImage.asImageBitmap() }
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Image(
            bitmap = capturedImageBitmap,
            contentDescription = "Foto tomada"
        )
    }
}

@Composable
private fun getBase64String(context: Context, base64: String) {
    Toast.makeText(context, base64, Toast.LENGTH_LONG).show()
}


@Composable
private fun CameraContent(
    onPhotoCaptured: (Bitmap) -> Unit
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { androidx.compose.material3.Text(text = "Tomar foto") },
                onClick = {
                    val mainExecutor = ContextCompat.getMainExecutor(context)

                    cameraController.takePicture(mainExecutor, object : ImageCapture.OnImageCapturedCallback() {
                        override fun onCaptureSuccess(image: ImageProxy) {

                            val correctedBitmap: Bitmap = image
                                .toBitmap()
                                .rotateBitmap(image.imageInfo.rotationDegrees)

                            onPhotoCaptured(correctedBitmap)

                            image.close()
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Log.e("Camara", "Error guardando imagen", exception)
                        }
                    })
                }
            )
        }
    ) { paddingValues: PaddingValues ->
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            factory = { context ->
                PreviewView(context).apply {
                    layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    setBackgroundColor(Color.BLACK)
                    implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                    scaleType = PreviewView.ScaleType.FILL_START
                }.also { previewView ->
                    previewView.controller = cameraController
                    cameraController.bindToLifecycle(lifecycleOwner)
                }
            }
        )
    }
}
