package com.demo.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.demo.R
import com.demo.base.BaseActivity
import com.demo.login.LoginActivity
import com.demo.sharedPref.SharedPref
import com.demo.utils.Utility

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Make full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        if (SharedPref.getValue(this, SharedPref.TOKEN, "") == "") {
            Handler(Looper.getMainLooper()).postDelayed({
                Utility.openActivity(this, LoginActivity::class.java)
                finish()
            }, 1000)
        } else {
             // User is already Logged in , Redirect to Home or other Required screen
        }
    }
}