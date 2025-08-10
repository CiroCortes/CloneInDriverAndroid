package com.cirodevs.indrverclonekotlin.presentation.screens.profile.info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileInfoViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set
    // once the viewmodel is invoked we call the getSessionData() with init
    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCases.getSessionData().collect { data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch {
        authUseCases.logout()
    }
}