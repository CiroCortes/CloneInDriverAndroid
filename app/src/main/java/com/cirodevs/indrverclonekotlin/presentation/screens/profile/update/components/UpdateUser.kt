package com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import com.cirodevs.indrverclonekotlin.presentation.components.ProgressBar
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.client.ClientScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginViewModel
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.ProfileUpdateViewModel


@Composable
fun UpdateUser (navHostController: NavHostController,vm : ProfileUpdateViewModel = hiltViewModel()) {
    val context = LocalContext.current
    when(val response = vm.updateResponse){
        // don't we using the "is" in Loading, because we using this like an object
        // so we can use the "is" operator, when using a class
        Resource.Loading -> {
            ProgressBar()

        }
        is Resource.Success -> {
//            LaunchedEffect(Unit) {
//                vm.saveSession(response.data)
//                navHostController.navigate(route = Graph.CLIENT){
//                    // this is to clear the stack, if a user is logged in we don't want to go back
//                    // to the login screen
//                    popUpTo(Graph.AUTH){
//                        inclusive = true
//                    }
//                }
//            }
            vm.updateUserSession(response.data)
            Toast.makeText(context, "Datos actualizados", Toast.LENGTH_LONG).show()

        }
        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
        }

    }
}