package com.capstone.destimate.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.destimate.R
import com.capstone.destimate.utils.ViewModelFactory
import com.capstone.destimate.view.login.LoginActivity
import com.capstone.destimate.view.main.MainActivity

class SplashActivity : AppCompatActivity() {
    private val splashTimeout: Long = 2000 // 2 seconds
    private lateinit var viewModel: SplashViewModel
    private lateinit var splashIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[SplashViewModel::class.java]

        viewModel.getSession().observe(this){
            splashIntent = if (it.isLogin){
                Intent(this@SplashActivity, MainActivity::class.java)
            } else {
                Intent(this@SplashActivity, LoginActivity::class.java)
            }
        }

        Handler().postDelayed({
            startActivity(splashIntent)
            finish()
        }, splashTimeout)

    }
}