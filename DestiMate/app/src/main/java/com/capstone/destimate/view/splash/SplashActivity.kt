package com.capstone.destimate.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.capstone.destimate.R
import com.capstone.destimate.view.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private val splashTimeout: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Start the main activity after the splash timeout
            val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }, splashTimeout)

    }
}