package com.cirodevs.indrverclonekotlin.presentation.screens.auth.login

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.components.Login
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.components.LoginContents


@Composable
fun LoginScreen(navHostController: NavHostController) {


    Scaffold(
        // esta propiedad es para que el scaffold se adapte a la barra de navegacion
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues -> // siempre usamos paddincalues con el scaffold

        LoginContents(
            navHostController = navHostController,
            paddingValues = paddingValues
        )

    }
    Login(navHostController)
}