package com.cirodevs.indrverclonekotlin.presentation.screens.profile.update

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.components.ProfileUpdateContent
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.components.UpdateUser


@Composable
fun ProfileUpdateScreen( navHostController: NavHostController, userParam: String) {

    Log.d("ProfileUpdateScreen", "userParam: $userParam")

    Scaffold (
        contentWindowInsets = WindowInsets.navigationBars
    ){ paddingValues ->
        ProfileUpdateContent(navHostController = navHostController, paddingValues = paddingValues)

    }
    UpdateUser(navHostController = navHostController)
}