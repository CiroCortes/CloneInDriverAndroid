package com.cirodevs.indrverclonekotlin.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cirodevs.indrverclonekotlin.core.Config.AUTH_KEY
import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// in this class we will use shared preferences for store the data

class LocalDataStore( private val datastore : DataStore<Preferences>) {

    suspend fun save(authResponse: AuthResponse) {
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        datastore.edit { pref ->
            pref[datastoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete(){
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        datastore.edit { pref ->
            pref.remove(datastoreKey)
        }
    }

    fun getData(): Flow<AuthResponse> {
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        return datastore.data.map { pref ->
            // here we check if the value is null, if it is null we return an empty AuthResponse
            if (pref[datastoreKey] != null) {
                AuthResponse.fromJson(pref[datastoreKey]!!)
            } else {
                AuthResponse()
            }
        }
    }

}