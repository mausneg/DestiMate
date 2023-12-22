package com.capstone.destimate.view.userdetail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.capstone.destimate.databinding.ActivityUserBinding
import com.capstone.destimate.utils.ViewModelFactory
import com.capstone.destimate.view.splash.SplashActivity

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[UserViewModel::class.java]


        initView()
        initAction()
    }

    private fun initView(){
        viewModel.getSession().observe(this){
            binding.tvUserEmail.text = it.email
            binding.tvUserUsername.text = it.name

            Glide.with(this@UserActivity)
                .load(it.photoUrl)
                .transform(CenterCrop(), RoundedCorners(70))
                .into(binding.imgUserProfile)
        }
    }

    private fun initAction(){
        binding.btUserLogout.setOnClickListener {
            viewModel.logout()
            Toast.makeText(this, "Logout success!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@UserActivity, SplashActivity::class.java))
            finish()
        }
    }
}