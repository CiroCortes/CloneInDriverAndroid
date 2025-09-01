package com.cirodevs.indrverclonekotlin.domain.useCases.location

import com.cirodevs.indrverclonekotlin.domain.repository.LocationRepository

class GetPlacePredictionUseCase (private val repository: LocationRepository) {

    suspend operator fun invoke(query: String) = repository.getPlacePredictions(query)
}