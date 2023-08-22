package com.demo.api

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {

    @POST
    suspend fun callPostApi(@Url url: String,@Body params: JsonObject): Response<ResponseBody>

    @POST
    suspend fun callPostApi(@Url url: String, @Header(WebField.AUTHORIZATION) authorization: String?, @Body params: JsonObject): Response<ResponseBody>

    @POST
    suspend fun callPostApiWithImageHeader(@Url url: String,@Header(WebField.AUTHORIZATION) authorization: String?,@Body  image: MultipartBody): Response<ResponseBody>

//    @DELETE
//    suspend fun callDeleteApi(@Url url: String, @Header(WebField.AUTHORIZATION) authorization: String?): Response<ResponseBody>
//
//    @PATCH
//    suspend fun callPatchApi(@Url url: String, @Header(WebField.AUTHORIZATION) authorization: String?, @Body params: JsonObject): Response<ResponseBody>

    @GET
    suspend fun callGetApi(@Url url: String, @Header(WebField.AUTHORIZATION) authorization: String?): Response<ResponseBody>

    companion object {

        var loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        var httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder().baseUrl(WebField.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}