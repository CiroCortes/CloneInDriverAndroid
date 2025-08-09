package com.cirodevs.indrverclonekotlin.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.AuthUseCases
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCases) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    // whit be came the session data
    init{
        getSessionData()
    }


    fun onEmailInput(email: String) {
        state = state.copy( email = email)
    }
    fun onPasswordInput(password: String) {
        state = state.copy( password = password)
    }
    // here we use the viewmodelScope for the coroutines of the login, also we don't know
    // the result of the login is now o may be later
     fun login() = viewModelScope.launch {
         if(isValidForm()){
             loginResponse = Resource.Loading // this indicates that the login is in progress
             Log.d("LoginViewModel", "Email: ${state.email}, Password: ${state.password}")
             val result = authUseCase.login(state.email, state.password)
             // later we obten the result of the login, store these results in the loginResponse
             // may be it SUCCESS or FAILURE
             loginResponse = result
             Log.d("LoginViewModel", "Result: $result")
         }

     }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect { data ->
            Log.d("LoginViewModel", "Data de sesion: ${data}")
            // whit this we hold the sesion data in the app, also we validaye whit if
            if(!data.token.isNullOrEmpty()) {
                loginResponse = Resource.Success(data)
            }




        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
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