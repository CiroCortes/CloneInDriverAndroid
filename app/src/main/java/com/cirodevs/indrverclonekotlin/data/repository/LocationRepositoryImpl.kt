package com.cirodevs.indrverclonekotlin.data.repository

import com.cirodevs.indrverclonekotlin.data.dataSource.location.LocationDataSource
import com.cirodevs.indrverclonekotlin.domain.repository.LocationRepository
import com.google.android.gms.maps.model.LatLng

class LocationRepositoryImpl(private val locationDataSource: LocationDataSource): LocationRepository {
    override fun getLocationUpdates(callback: (LatLng) -> Unit) {
        locationDataSource.getLocationUpdates(callback)

    }
}