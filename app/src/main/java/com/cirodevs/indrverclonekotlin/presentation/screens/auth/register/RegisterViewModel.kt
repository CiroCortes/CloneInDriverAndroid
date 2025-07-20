package com.cirodevs.indrverclonekotlin.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set
    var errorMessage by mutableStateOf("")

    fun onNameInput(name: String) {
        state = state.copy( name = name)
    }
    fun onLastNameInput(lastname: String) {
        state = state.copy( lastName = lastname)
    }
    fun onEmailInput(email: String) {
        state = state.copy( email = email)
    }
    fun onPhoneInput(phone: String) {
        state = state.copy( phone = phone)
    }
    fun onPasswordInput(password: String) {
        state = state.copy( password = password)
    }
    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy( confirmPassword = confirmPassword)
    }

    fun isValidForm(): Boolean {
        errorMessage = ""
        if(state.name.isEmpty() ){
            errorMessage = "Name is required"
            return false
        }
        else if(state.lastName.isEmpty() ){
            errorMessage = "LastName is required"
            return false
        }
        else if(state.email.isEmpty() ){
            errorMessage = "Email is required"
            return false
        }
        else if(state.phone.isEmpty() ){
            errorMessage = "Phone is required"
            return false
        }
        else if(state.password.isEmpty() ) {
            errorMessage = "Password is required"
            return false
        }
        else if(state.confirmPassword.isEmpty() ) {
            errorMessage = "Confirm Password is required"
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
        else if(state.password != state.confirmPassword){
            errorMessage = "Passwords do not match"
            return false
        }

        return true
    }
    fun register() {
        if (isValidForm()) {
            Log.d(
                "RegisterViewModel",
                "Name: ${state.name}, " +
                        "LastName: ${state.lastName}, " +
                        "Email: ${state.email}, " +
                        "Phone: ${state.phone}, " +
                        "Password: ${state.password}"
            )
        }
    }
}