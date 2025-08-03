package com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.contents

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import com.cirodevs.indrverclonekotlin.presentation.components.ProgressBar
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(vm: RegisterViewModel = hiltViewModel()) {

    val context = LocalContext.current
    when(val response = vm.registerResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
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