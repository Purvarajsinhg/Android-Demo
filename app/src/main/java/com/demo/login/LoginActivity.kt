package com.demo.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.demo.R
import com.demo.databinding.ActivityLoginBinding
import com.demo.api.MainRepository
import com.demo.api.RetrofitService
import com.demo.api.WebField
import com.demo.base.BaseActivity
import com.demo.utils.Constant
import com.demo.utils.SnakebarUtility
import com.demo.utils.Utility
import com.google.gson.JsonObject

class LoginActivity : BaseActivity() {

    private var activityLoginBinding: ActivityLoginBinding? = null
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        setData()
    }

    // Set data / listners
    private fun setData(){
        activityLoginBinding?.txtLogin?.setOnClickListener {
            checkValidation()
        }
    }

    // Checking validations
    private fun checkValidation() {
        if (activityLoginBinding?.edtEmail?.text.toString().trim() == "") {
            activityLoginBinding?.txtInpLayoutEmail?.error = resources.getString(R.string.str_enter_email)

        } else if (!Utility.isValidEmail(activityLoginBinding?.edtEmail?.text.toString().trim())) {
            activityLoginBinding?.txtInpLayoutEmail?.error = resources.getString(R.string.str_enter_valid_email)

        } else if (activityLoginBinding?.edtPassword?.text.toString().trim() == "") {
            activityLoginBinding?.txtInpLayoutEmail?.error = null
            activityLoginBinding?.txtInpLayoutPassword?.error = resources.getString(R.string.str_enter_password)

        } else {
            activityLoginBinding?.txtInpLayoutEmail?.error = null
            activityLoginBinding?.txtInpLayoutPassword?.error = null
            callLoginAPI()
        }
    }

    // Call API
    private fun callLoginAPI() {
        try {
            Utility.showDialog(this, layoutInflater, activityLoginBinding?.constraintMain!!)
            val retrofitService = RetrofitService.getInstance()
            val mainRepository = MainRepository(retrofitService)

            val jsonObject = JsonObject()
            jsonObject.addProperty(WebField.EMAIL, activityLoginBinding?.edtEmail?.text.toString())
            jsonObject.addProperty(WebField.PASSWORD, activityLoginBinding?.edtPassword?.text.toString())
            jsonObject.addProperty(WebField.ROLE, WebField.ROLE_DRIVER)
            jsonObject.addProperty(WebField.DEVICE_NAME, Constant.DEVICE_TYPE_ANDROID)
            jsonObject.addProperty(WebField.DEVICE_TOKEN, "")
            jsonObject.addProperty(WebField.DEVICE_NAME,Constant.DEVICE_TYPE_ANDROID)

            loginViewModel = LoginViewModel(mainRepository, jsonObject, this)
            loginViewModel.loginData.observe(this)
            {
                Utility.hideDialog(activityLoginBinding?.constraintMain!!)
                // Login success
            }

            loginViewModel.error.observe(this) {
                Utility.hideDialog(activityLoginBinding?.constraintMain!!)
                if (it.getString(WebField.CODE) == Constant.ERROR_401) {
                    Utility.openActivityClearBackStackWithData(this, LoginActivity::class.java)
                } else {
                    SnakebarUtility.showSnackBarWithoutAction(it.getString(WebField.MESSAGE),activityLoginBinding?.constraintMain!!,this)
                }
            }

            loginViewModel.errorMsg.observe(this) {
                Utility.hideDialog(activityLoginBinding?.constraintMain!!)
                SnakebarUtility.showSnackBarWithoutAction(it.toString(),activityLoginBinding?.constraintMain!!,this)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}