package com.cirodevs.indrverclonekotlin.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.cirodevs.indrverclonekotlin.core.Config.AUTH_PREF
import com.cirodevs.indrverclonekotlin.data.dataSource.local.datastore.LocalDataStore
import com.cirodevs.indrverclonekotlin.data.dataSource.location.LocationDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Provides
    @Singleton
    fun provideLocationDataSource(@ApplicationContext context: Context): LocationDataSource =
        LocationDataSource(context)




}
