package com.cirodevs.indrverclonekotlin.domain.util

import android.util.Log
import com.cirodevs.indrverclonekotlin.domain.model.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody

object ErrorHelper {

    fun handleError(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.string()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception) {
            Log.d("ErrorHelper", "Error: ${e.message}")
            null
        }

    }
}