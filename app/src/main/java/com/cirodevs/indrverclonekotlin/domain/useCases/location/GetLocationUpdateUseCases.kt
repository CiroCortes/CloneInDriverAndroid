package com.cirodevs.indrverclonekotlin.domain.useCases.location

import com.cirodevs.indrverclonekotlin.domain.repository.LocationRepository
import com.google.android.gms.maps.model.LatLng

class GetLocationUpdateUseCases (private val repository: LocationRepository) {

    operator fun invoke(callback: (position:LatLng) -> Unit) = repository.getLocationUpdates(callback)

}