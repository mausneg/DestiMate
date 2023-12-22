package com.capstone.destimate.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.destimate.data.repository.Result
import com.capstone.destimate.databinding.ActivityLoginBinding
import com.capstone.destimate.utils.ViewModelFactory
import com.capstone.destimate.view.main.MainActivity
import com.capstone.destimate.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[LoginViewModel::class.java]

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initAction()
    }

    private fun initView(){
        viewModel.getLoginResult().observe(this){result ->
            if(result != null){
                when(result){
                    is Result.Loading -> {
                        isLoading(true)
                    }

                    is Result.Success -> {
                        viewModel.saveSession()
                        Toast.makeText(this, "Login success!", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }

                    is Result.Error -> {
                        Toast.makeText(this, "Login failed: ${result.error}!", Toast.LENGTH_LONG)
                            .show()
                        isLoading(false)
                    }
                }
            }
        }

    }

    private fun initAction(){
        binding.apply {
            btLoginSignup.setOnClickListener {
                val signupIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(signupIntent)
            }
            btLoginLogin.setOnClickListener {
                val email = edLoginEmail.text.toString().trim()
                val password = edLoginPassword.text.toString().trim()
                viewModel.login(email, password)
            }
        }
    }

    private fun isLoading(isLoading: Boolean){
        binding.apply {
            if (isLoading){
                pbLogin.visibility = View.VISIBLE
                tvLoginTitle.visibility = View.INVISIBLE
                tvLoginMessage.visibility = View.INVISIBLE
                etlLoginEmail.visibility = View.INVISIBLE
                etlLoginPassword.visibility = View.INVISIBLE
                btLoginSignup.visibility = View.INVISIBLE
                btLoginLogin.visibility = View.INVISIBLE
            } else {
                pbLogin.visibility = View.INVISIBLE
                tvLoginTitle.visibility = View.VISIBLE
                tvLoginMessage.visibility = View.VISIBLE
                etlLoginEmail.visibility = View.VISIBLE
                etlLoginPassword.visibility = View.VISIBLE
                btLoginSignup.visibility = View.VISIBLE
                btLoginLogin.visibility = View.VISIBLE
            }
        }
    }
}