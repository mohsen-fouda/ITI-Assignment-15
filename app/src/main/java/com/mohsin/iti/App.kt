package com.mohsin.iti

import android.app.Application
import com.mohsin.iti.utils.MySharedPreferences

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPreferences.init(this)
    }
}