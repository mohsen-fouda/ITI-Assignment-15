package com.mohsin.iti.utils;


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
@SuppressLint("StaticFieldLeak")

 object MySharedPreferences {
    private var mContext: Context? = null
    private const val SHARED_PREFERENCES_NAME = "test lab 8"
    private const val USER_EMAIL = "user email"

     fun init(context: Context) {
         mContext = context
     }

     private fun getSharedPreferences(): SharedPreferences = mContext!!.getSharedPreferences(
         SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE
     )


    fun setUserEmail(email: String) {

        val editor = getSharedPreferences().edit()
        editor.putString(USER_EMAIL, email).apply()

    }

     fun getUserEmail(): String {
        return getSharedPreferences().getString(USER_EMAIL, "")!!

    }
    fun putBoolean(key: String, value: Boolean) {
        val editor = getSharedPreferences().edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String, b: Boolean): Boolean {
        return getSharedPreferences().getBoolean(key, false)
    }
    fun clear() {
        val editor = getSharedPreferences().edit()
        editor.clear()
        editor.apply()
        setUserEmail("")

    }

}