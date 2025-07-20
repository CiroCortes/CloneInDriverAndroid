package com.cirodevs.indrverclonekotlin.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun DefaultOutlineTextField(
    modifier: Modifier,
    value: String,
    label: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit,
    // Evento para el teclado es para saber si sera de tipo numerico o de texto
    keyboardType: KeyboardType = KeyboardType.Text, // Por defecto es texto
    hideText: Boolean = false // Ocultar la contraseña
) {
    Box(
        modifier = modifier
            .height(55.dp)


    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                text -> onValueChange(text)
            },
            label = { Text(text = label) },
            leadingIcon = {
                Row (){
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Spacer(
                        modifier = Modifier
                        .height(20.dp)
                        .width(1.dp)
                        .background(color = Color.Black)
                    )
                }

            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Transparent,
//                unfocusedContainerColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                disabledIndicatorColor = Color.Transparent


        )

    }
}