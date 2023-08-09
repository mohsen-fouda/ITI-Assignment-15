package com.mohsin.iti.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohsin.iti.databinding.ActivityMoreBinding
import com.mohsin.iti.utils.Const

class MoreActivity : AppCompatActivity() {
    private var _binding: ActivityMoreBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMoreBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        getDetails()
    }

    private fun getDetails() {
        val userName=intent.getStringExtra(Const.USERNAME)
        val post=intent.getStringExtra(Const.POST)
        binding.txtUsername.text="Username: $userName"
        binding.txtPost.text="post: $post"

    }

}