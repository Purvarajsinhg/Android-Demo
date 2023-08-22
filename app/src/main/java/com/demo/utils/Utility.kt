package com.demo.utils

import android.app.*
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import com.demo.R
import com.demo.sharedPref.SharedPref

object Utility {

    fun openActivity(activity: Activity, aClass: Class<*>) {
        hideKeyboard(activity)
        val intent1 = Intent(activity, aClass)
        activity.startActivity(intent1)
    }
    // Common method for Navigation from one Activity to another with Backstack clear
    fun openActivityClearBackStack(activity: Activity, aClass: Class<*>) {
        hideKeyboard(activity)
        val intent1 = Intent(activity, aClass)
        intent1.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        activity.startActivity(intent1)
    }

    // Common method for Navigation from one Activity to another
    fun openActivityClearBackStackWithData(activity: Activity, aClass: Class<*>) {
        hideKeyboard(activity)
        SharedPref.clearAllPref(activity)
        val intent1 = Intent(activity, aClass)
        intent1.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        activity.startActivity(intent1)
    }

    private fun hideKeyboard(activity: Activity) {
        if (activity.currentFocus != null) {
            val inputMethodManager =
                activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        }
    }

    // Check Email validation
    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Check Password validation
    fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }

    // Progress Dialog Methods
    fun showDialog(context: Context, layoutInflater: LayoutInflater, views: ConstraintLayout)
    {
        val view = layoutInflater.inflate(R.layout.progress, null)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        val ll = LinearLayout(context)
        ll.gravity = Gravity.CENTER
        ll.addView(view)
        views.addView(ll, params)
        disableEnableControls(false,views)
    }

    fun hideDialog(views: ConstraintLayout)
    {
        val view = views[views.childCount.minus(1)]
        views.removeView(view)
        disableEnableControls(true,views)
    }

    // Disable / Enable controls of Activity when API is called
    private fun disableEnableControls(enable: Boolean, vg: ViewGroup) {
        for (i in 0 until vg.childCount) {
            val child = vg.getChildAt(i)
            child.isEnabled = enable
            if (child is ViewGroup) {
                disableEnableControls(enable, child)
            }
        }
    }
}