package com.demo.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.api.MainRepository
import com.demo.api.NetworkState
import com.demo.api.WebField
import com.demo.utils.AlertDialogutility
import com.demo.utils.NetworkHelper
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.*
import org.json.JSONObject

class LoginViewModel constructor(private val mainRepository: MainRepository, jsonObject : JsonObject, context: Context) : ViewModel() {
    var loginData = MutableLiveData<LoginModel>()
    var error = MutableLiveData<JSONObject>()
    var errorMsg = MutableLiveData<String>()

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _ , throwable ->
        errorMsg.postValue(throwable.message)
    }

    private fun callLoginAPI(context: Context, jsonObject : JsonObject)
    {
        try {
            viewModelScope.launch (coroutineExceptionHandler){

                if (NetworkHelper.isNetworkConnected(context))
                {
                    when (val response = mainRepository.callPostAPI(WebField.LOGIN,jsonObject))
                    {
                        is NetworkState.Success ->
                        {
                            val loginModel = Gson().fromJson(response.response?.string(), LoginModel::class.java)
                            loginData.postValue(loginModel)
                        }
                        is NetworkState.Error<*> ->
                        {
                             val jObj = JSONObject(response.response.errorBody()!!.string())
                             error.postValue(jObj)
                        }
                    }
                }
                else {
                    AlertDialogutility.showInternetAlert(context)
                }
            }
        }catch (e:Exception)
        {
            e.printStackTrace()
        }
    }

    init {
        callLoginAPI(context,jsonObject)
    }
}