package com.capstone.destimate.view.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.destimate.databinding.ActivityLoginBinding
import com.capstone.destimate.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLoginSignup.setOnClickListener {
            val signupIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(signupIntent)

        }
    }
}