package com.cirodevs.indrverclonekotlin.domain.useCases.location

import com.cirodevs.indrverclonekotlin.domain.repository.LocationRepository

class GetPlaceDetailsUseCase (private val repository: LocationRepository) {

    suspend operator fun invoke(placeId: String) = repository.getPlaceDetails(placeId)
}