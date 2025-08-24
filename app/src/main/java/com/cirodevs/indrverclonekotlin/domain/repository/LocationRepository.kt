package com.cirodevs.indrverclonekotlin.domain.repository

import com.google.android.gms.maps.model.LatLng

interface LocationRepository {

    fun getLocationUpdates(callback: (position: LatLng)-> Unit)
}