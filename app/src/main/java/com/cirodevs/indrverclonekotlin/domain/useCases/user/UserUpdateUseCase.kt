package com.cirodevs.indrverclonekotlin.domain.useCases.user

import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.repository.UserRepository
import java.io.File

class UserUpdateUseCase (private val repository: UserRepository) {
    suspend operator fun invoke(id: String, user: User, file: File?) = repository.update(id, user, file)

}