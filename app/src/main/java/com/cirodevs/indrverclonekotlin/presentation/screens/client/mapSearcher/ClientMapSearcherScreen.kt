package com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher.components.ClientMapSearcherContent

@Composable
fun ClientMapSearcherScreen(navHostController: NavHostController, vm: ClientMapSearcherViewModel = hiltViewModel()) {

    val context = LocalContext.current

    var hasPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {
                isGranted ->
            hasPermission = isGranted
            if(isGranted){
                vm.starLocationUpdates()
            }
        }
    )

    LaunchedEffect(Unit){
        // aqui negamos y preguntamos si el permiso es false, y llamamos nuevamente al launcher
        if(!hasPermission){
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }else{
            vm.starLocationUpdates()
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    )
    { paddingValues ->
        if(hasPermission){
            ClientMapSearcherContent(
                navHostController = navHostController,
                paddingValues = paddingValues
            )

        }else{
            Text("No tienes permiso, por favor habilita los persimos en tu telefono")
        }

    }
}