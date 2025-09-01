package com.cirodevs.indrverclonekotlin.domain.useCases.location

data class LocationUseCases (
    val getLocationUpdateUseCases: GetLocationUpdateUseCases,
    val getPlacePredictionUseCase: GetPlacePredictionUseCase,
    val getPlaceDetailsUseCase: GetPlaceDetailsUseCase
)