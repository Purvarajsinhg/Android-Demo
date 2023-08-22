package com.demo.api

import android.content.Context
import com.demo.sharedPref.SharedPref
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.ResponseBody

class MainRepository constructor(private val retrofitService: RetrofitService)
{
    suspend fun callPostAPI(url: String,jsonObject: JsonObject): NetworkState<ResponseBody?>
    {
        val response = retrofitService.callPostApi(url , jsonObject)

        return if (response.isSuccessful)
        {
            val responseBody = response.body()
            if (responseBody != null)
            {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Success(null)
            }
        } else {
            NetworkState.Error(response)
        }
    }

    suspend fun callPostAPIWithHeader(context: Context,url: String,jsonObject: JsonObject): NetworkState<ResponseBody?>
    {
        val response = retrofitService.callPostApi(url,SharedPref.getValue(context, SharedPref.TOKEN,""),jsonObject)

        return if (response.isSuccessful)
        {
            val responseBody = response.body()
            if (responseBody != null)
            {
                NetworkState.Success(responseBody)
            }
            else {
                NetworkState.Success(responseBody)
            }
        } else {
            NetworkState.Error(response)
        }
    }

    suspend fun callPostAPIUploadImageWithHeader(context: Context,url: String,body : MultipartBody): NetworkState<ResponseBody?>
    {
        val response = retrofitService.callPostApiWithImageHeader(url,SharedPref.getValue(context, SharedPref.TOKEN,""),body)

        return if (response.isSuccessful)
        {
            val responseBody = response.body()
            if (responseBody != null)
            {
                NetworkState.Success(responseBody)
            }
            else {
                NetworkState.Success(responseBody)
            }
        } else {
            NetworkState.Error(response)
        }
    }

    suspend fun callGetAPI (context: Context,url: String):  NetworkState<ResponseBody?>
    {
        val response = retrofitService.callGetApi(url, SharedPref.getValue(context, SharedPref.TOKEN, "")!!)

        return if (response.isSuccessful)
        {
            val responseBody = response.body()

            if (responseBody != null)
            {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Success(responseBody)
            }
        } else {
            NetworkState.Error(response)
        }
    }

//    suspend fun callDeleteAPI (context: Context):  NetworkState<ResponseBody?>
//    {
//        val response = retrofitService.callDeleteApi(url,SharedPref.getValue(context,SharedPref.TOKEN,""))
//
//        return if (response.isSuccessful)
//        {
//            val responseBody = response.body()
//            if (responseBody != null)
//            {
//                NetworkState.Success(responseBody)
//            } else {
//                NetworkState.Success(responseBody)
//            }
//        } else {
//            NetworkState.Error(response)
//        }
//    }
//
//    suspend fun callPatchAPI (context: Context,jsonObject: JsonObject):  NetworkState<ResponseBody?>
//    {
//        val response = retrofitService.callPatchApi(url,SharedPref.getValue(context,SharedPref.TOKEN,""),jsonObject)
//
//        return if (response.isSuccessful)
//        {
//            val responseBody = response.body()
//            if (responseBody != null)
//            {
//                NetworkState.Success(responseBody)
//            } else {
//                NetworkState.Success(responseBody)
//            }
//        } else {
//            NetworkState.Error(response)
//        }
//    }
}