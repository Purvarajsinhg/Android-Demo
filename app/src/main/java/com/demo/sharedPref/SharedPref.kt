package com.demo.sharedPref

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private var sharedPreferences: SharedPreferences? = null
    private const val PREF_NAME = "DemoApp"

    // Login Token
    const val TOKEN = "Token"

    private fun openPref(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    }

    fun clearAllPref(context: Context) {
        context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE).edit().clear().apply()
    }

    // STRING

    fun getValue(
        context: Context, key: String?,
        defaultValue: String?
    ): String? {
        openPref(context)
        val result = sharedPreferences!!.getString(key, defaultValue)
        sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String?, value: String?) {
        openPref(context)
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor.putString(key, value)
        prefsPrivateEditor.apply()
        sharedPreferences = null
    }

    // BOOLEAN

    fun getValue(
        context: Context, key: String?,
        defaultValue: Boolean
    ): Boolean {
        openPref(context)
        val result = sharedPreferences!!.getBoolean(key, defaultValue)
        sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String?, value: Boolean) {
        openPref(context)
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor.putBoolean(key, value)
        prefsPrivateEditor.apply()
        sharedPreferences = null
    }

    // INT

    fun getValue(
        context: Context, key: String?,
        defaultValue: Int
    ): Int {
        openPref(context)
        val result = sharedPreferences!!.getInt(key, defaultValue)
        sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String?, value: Int) {
        openPref(context)
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor.putInt(key, value)
        prefsPrivateEditor.apply()
        sharedPreferences = null
    }
}