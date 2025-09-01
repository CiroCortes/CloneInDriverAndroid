package com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirodevs.indrverclonekotlin.domain.model.PlacePrediction
import com.cirodevs.indrverclonekotlin.domain.useCases.location.LocationUseCases
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientMapSearcherViewModel @Inject constructor( private val locationUseCases: LocationUseCases) : ViewModel() {

    private val _location = MutableStateFlow<LatLng?>(null)
    val location: StateFlow<LatLng?> get() = _location

    private val _placePrediction = MutableStateFlow<List<PlacePrediction>>(emptyList())
    val placePrediction: StateFlow<List<PlacePrediction>> get() = _placePrediction

    private val _selectedPlace = MutableStateFlow<Place?>(null)
    val selectedPlace: StateFlow<Place?> get() = _selectedPlace


    fun starLocationUpdates() = viewModelScope.launch {
        locationUseCases.getLocationUpdateUseCases{ position ->
            _location.value = position

        }

    }

    fun getPlacePrediction(query: String) = viewModelScope.launch {
        _placePrediction.value = locationUseCases.getPlacePredictionUseCase(query)
    }

    fun getPlaceDetails(placeId: String) = viewModelScope.launch {
        _selectedPlace.value = locationUseCases.getPlaceDetailsUseCase(placeId)
    }

    }
