package com.cirodevs.indrverclonekotlin.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DefaultButtom(
    modifier: Modifier,
    text: String,
    onclick: () -> Unit,
    color: Color = Color.Black,
    height: Dp = 55.dp,
    width: Dp = 250.dp,

) {

    Box(modifier = Modifier
        .fillMaxWidth()

    ) {
        Button( modifier = modifier
            .align(Alignment.Center)
            .width(width)
            .height(height),
            onClick = {onclick()},
            colors = ButtonDefaults.buttonColors( color)
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                color = Color.White
            )
        }

    }

}