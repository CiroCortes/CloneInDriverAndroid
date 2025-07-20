package com.cirodevs.indrverclonekotlin.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    fun onEmailInput(email: String) {
        state = state.copy( email = email)
    }
    fun onPasswordInput(password: String) {
        state = state.copy( password = password)
    }
     fun login() {
         if(isValidForm()){
             Log.d("LoginViewModel", "Email: ${state.email}, Password: ${state.password}")
         }

     }

    fun isValidForm(): Boolean {

        errorMessage = ""

        if(state.email.isEmpty() ){
            errorMessage = "Email is required"
            return false
        }
        else if(state.password.isEmpty() ){
            errorMessage = "Password is required"
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Email is not valid"
            return false
        }
        else if(state.password.length < 6){
            errorMessage = "Password must be at least 6 characters"
            return false
        }
        return true
    }

}