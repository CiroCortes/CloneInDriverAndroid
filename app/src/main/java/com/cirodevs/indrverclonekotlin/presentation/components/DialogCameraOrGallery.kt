package com.cirodevs.indrverclonekotlin.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogCameraOrGallery(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit
) {
    // this show the dialog
    if (state.value) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            containerColor = Color.White,
            onDismissRequest = { state.value = false },
            title = {
                Text(
                    text = "Selecciona una opción",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            },
            confirmButton = {
                TextButton (
                    modifier = Modifier
                        .width(130.dp),
                    onClick = {
                        state.value = false
                        pickImage()
                    }
                ){
                    Text(
                        text = "Galería"
                    )
                }
            },
            dismissButton = {
                TextButton (
                    modifier = Modifier
                        .width(130.dp),
                    onClick = {
                        state.value = false
                        takePhoto()
                    }
                ){
                    Text(
                        text = "Cámara"
                    )
                }
            }
        )
    }
}