package com.cirodevs.indrverclonekotlin.domain.repository

import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import java.io.File

interface UserRepository {

    suspend fun update(id: String, user: User, file: File?): Resource<User>



}