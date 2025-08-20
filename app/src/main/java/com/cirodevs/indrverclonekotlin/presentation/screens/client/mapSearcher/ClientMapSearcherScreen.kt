package com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher.components.ClientMapSearcherContent

@Composable
fun ClientMapSearcherScreen(navHostController: NavHostController) {
    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    )
    { paddingValues ->
        ClientMapSearcherContent(
            navHostController = navHostController,
            paddingValues = paddingValues
        )
    }
}