package com.cirodevs.indrverclonekotlin.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cirodevs.indrverclonekotlin.core.Config.AUTH_KEY
import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import com.cirodevs.indrverclonekotlin.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// in this class we will use shared preferences for store the data

class LocalDataStore( private val datastore : DataStore<Preferences>) {

    suspend fun save(authResponse: AuthResponse) {
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        datastore.edit { pref ->
            pref[datastoreKey] = authResponse.toJson()
        }
    }

    suspend fun update(user: User) {
        val datastoreKey = stringPreferencesKey(AUTH_KEY)

        val authResponse = runBlocking {
            getData().first() // the data is in the datastore, so we get it
        }

        // here in the first time we have the variable user model was a "val", together i changed to "var"
        // the tree parameters : name, lastname, phone, image (id and email are unique)
        authResponse.user?.name = user.name
        authResponse.user?.lastname = user.lastname
        authResponse.user?.phone = user.phone
        if(!user.image.isNullOrBlank()){
            authResponse.user?.image = user.image

        }





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