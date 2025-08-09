package com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.contents

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import com.cirodevs.indrverclonekotlin.presentation.components.ProgressBar
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(vm: RegisterViewModel = hiltViewModel(), navHostController: NavHostController) {

    val context = LocalContext.current
    when(val response = vm.registerResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navHostController.navigate(route = Graph.CLIENT){
                    // this is to clear the stack, if a user is logged in we don't want to go back
                    // to the login screen
                    popUpTo(Graph.AUTH){
                        inclusive = true
                    }
                }
            }

            //Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
        }
        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

}