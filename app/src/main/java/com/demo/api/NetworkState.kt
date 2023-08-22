package com.demo.api

import retrofit2.Response

sealed class NetworkState<out T> {
    data class Success<out T>(val response: T) : NetworkState<T>()
    data class Error<T>(val response: Response<T>) : NetworkState<T>()
}