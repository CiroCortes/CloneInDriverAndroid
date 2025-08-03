package com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import com.cirodevs.indrverclonekotlin.presentation.components.ProgressBar
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginViewModel


@Composable
fun Login (vm : LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current
    when(val response = vm.loginResponse){
        // don't we using the "is" in Loading, because we using this like an object
        // so we can use the "is" operator, when using a class
        Resource.Loading -> {
            ProgressBar()

        }
        is Resource.Success -> {
            Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()

        }
        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
        }

    }
}