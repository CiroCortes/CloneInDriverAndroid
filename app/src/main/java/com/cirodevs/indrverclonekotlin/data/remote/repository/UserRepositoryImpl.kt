package com.cirodevs.indrverclonekotlin.data.remote.repository

import android.util.Log
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.UserService
import com.cirodevs.indrverclonekotlin.data.util.HandleRequest
import com.cirodevs.indrverclonekotlin.domain.model.ErrorResponse
import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.repository.UserRepository
import com.cirodevs.indrverclonekotlin.domain.util.ErrorHelper
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class UserRepositoryImpl (private val userService: UserService) : UserRepository {
    override suspend fun update(id: String, user: User, file: File?): Resource<User> {

        if (file != null) { // here we actually send the image
            val connection = file.toURI().toURL().openConnection()
            val mimeType = connection.contentType // image png/jpg
            val contentType = "text/plain"
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
            val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
            val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
            val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())
            val result = userService.updateWhitImage( fileFormData, id, nameData, lastnameData, phoneData)
            return HandleRequest.send(result)


        } else { // without image send
            return HandleRequest.send(userService.update(id, user))

        }


    }

}