package com.mohsin.iti.ui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.mohsin.iti.R
import com.mohsin.iti.databinding.ActivityLoginBinding
import com.mohsin.iti.utils.Const
import com.mohsin.iti.utils.MySharedPreferences

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        actions()

    }

    private fun login() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        if (email.isEmpty()) {
            binding.edtEmail.error = getString(R.string.required)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = "invalid Email"
        } else if (password.isEmpty()) {
            binding.edtPassword.error = getString(R.string.required)
        } else {
            MySharedPreferences.setUserEmail(email)
            MySharedPreferences.putBoolean(Const.LOGINKEY, true)
            intent()
            finishAffinity()


        }
    }

    private fun actions() {
        binding.btnLogin.setOnClickListener {

            login()
        }
    }

    private fun intent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}