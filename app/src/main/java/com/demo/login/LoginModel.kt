package com.demo.login

import com.google.gson.annotations.SerializedName

data class LoginModel
    (
    @SerializedName("code"    ) var code    : Int?     = null,
    @SerializedName("status"  ) var status  : Boolean? = null,
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("data"    ) var data    : LoginData?    = LoginData()
)

data class LoginData (
    @SerializedName("firstname"   ) var firstname  : String? = null,
    @SerializedName("lastname"    ) var lastname   : String? = null,
    @SerializedName("email"       ) var email      : String? = null,
    @SerializedName("username"    ) var username   : String? = null,
    @SerializedName("phone"       ) var phone      : String? = null,
    @SerializedName("address"     ) var address    : String? = null,
    @SerializedName("profile_pic" ) var profilePic : String? = null,
    @SerializedName("avarage_rating" ) var avarage_rating : String? = null,
    @SerializedName("token"       ) var token      : String? = null
)