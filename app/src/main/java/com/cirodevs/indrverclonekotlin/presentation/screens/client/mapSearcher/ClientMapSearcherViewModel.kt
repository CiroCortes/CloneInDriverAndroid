package com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodevs.indrverclonekotlin.domain.useCases.location.LocationUseCases
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientMapSearcherViewModel @Inject constructor( private val locationUseCases: LocationUseCases) : ViewModel() {

    val location = mutableStateOf<LatLng?>(null)

    fun starLocationUpdates() = viewModelScope.launch {
        locationUseCases.getLocationUpdateUseCases{ position ->
            location.value = position

        }

    }

    }
