package com.cirodevs.indrverclonekotlin.di

import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import com.cirodevs.indrverclonekotlin.domain.repository.LocationRepository
import com.cirodevs.indrverclonekotlin.domain.repository.UserRepository
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.AuthUseCases
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.GetSessionDataUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.LoginUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.LogoutUseCse
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.RegisterUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.SaveSessionUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.UpdateSessionUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.location.GetLocationUpdateUseCases
import com.cirodevs.indrverclonekotlin.domain.useCases.location.GetPlaceDetailsUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.location.GetPlacePredictionUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.location.LocationUseCases
import com.cirodevs.indrverclonekotlin.domain.useCases.user.UserUpdateUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.user.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) = AuthUseCases (
            login = LoginUseCase(authRepository),
            register = RegisterUseCase(authRepository),
            saveSession = SaveSessionUseCase(authRepository),
            getSessionData = GetSessionDataUseCase(authRepository),
            logout = LogoutUseCse(authRepository),
            updateSession = UpdateSessionUseCase(authRepository)

    )

    @Provides
    fun provideUserUseCases(userRepository: UserRepository) = UserUseCases (
      update = UserUpdateUseCase(userRepository)

    )
    @Provides
    fun provideLocationUseCases(locationRepository: LocationRepository) = LocationUseCases(
            getLocationUpdateUseCases = GetLocationUpdateUseCases(locationRepository),
            getPlacePredictionUseCase = GetPlacePredictionUseCase(locationRepository),
            getPlaceDetailsUseCase = GetPlaceDetailsUseCase(locationRepository)
    )


}