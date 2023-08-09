package com.mohsin.iti.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mohsin.iti.R
import com.mohsin.iti.utils.MySharedPreferences

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        checkIfLoggedIn()
        setContentView(R.layout.activity_splash)
    }

    private fun checkIfLoggedIn() {
         if(MySharedPreferences.getUserEmail().isEmpty()){
             startActivity(Intent(this,LoginActivity::class.java))
         }
        else {
             startActivity(Intent(this,MainActivity::class.java))

         }
    }


}