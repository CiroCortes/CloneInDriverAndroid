package com.cirodevs.indrverclonekotlin.domain.repository

import com.cirodevs.indrverclonekotlin.domain.model.PlacePrediction
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.Place

interface LocationRepository {

    fun getLocationUpdates(callback: (position: LatLng)-> Unit)
    suspend fun getPlacePredictions(query: String): List<PlacePrediction>
    suspend fun getPlaceDetails(placeId: String): Place
}