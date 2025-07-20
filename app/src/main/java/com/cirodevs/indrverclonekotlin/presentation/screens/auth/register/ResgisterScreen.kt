package com.cirodevs.indrverclonekotlin.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.contents.RegisterContents
import com.cirodevs.indrverclonekotlin.ui.theme.InDriverCloneKotlinTheme

@Composable
fun ResgisterScreen (navHostController: NavHostController){


    Scaffold { paddingValues ->
        RegisterContents(
            navHostController = navHostController,
            paddingValues = paddingValues
        )

    }
}
@Preview( showBackground = true , showSystemUi = true)
@Composable
fun ResgisterScreenPreview(){
    InDriverCloneKotlinTheme {
        ResgisterScreen(rememberNavController())
    }

}