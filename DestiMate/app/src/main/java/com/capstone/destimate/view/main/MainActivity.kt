package com.capstone.destimate.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.capstone.destimate.data.repository.Result
import com.capstone.destimate.databinding.ActivityMainBinding
import com.capstone.destimate.utils.ViewModelFactory
import com.capstone.destimate.view.adapter.ListFavoriteAdapter
import com.capstone.destimate.view.adapter.ListNearbyAdapter
import com.capstone.destimate.view.adapter.ListRecommendationAdapter
import com.capstone.destimate.view.userdetail.UserActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[MainViewModel::class.java]
        setContentView(binding.root)

        val layoutManagerRecomendation = LinearLayoutManager(this)
        layoutManagerRecomendation.orientation = RecyclerView.HORIZONTAL
        binding.rvMainRekomendasi.layoutManager = layoutManagerRecomendation

        val layoutManagerNearby = LinearLayoutManager(this)
        layoutManagerNearby.orientation = RecyclerView.HORIZONTAL
        binding.rvMainNearby.layoutManager = layoutManagerNearby

        val layoutManagerFavorite = LinearLayoutManager(this)
        binding.rvMainFavorite.layoutManager = layoutManagerFavorite

        initView()
        initAction()
    }

    private fun initAction(){
        binding.imgMainUser.setOnClickListener {
            startActivity(Intent(this@MainActivity, UserActivity::class.java))
        }
    }

    private fun initView(){
        viewModel.getSession().observe(this){
            binding.apply {
                "Hi, ${it.name}!".also { tvMainGreeting.text = it }
                Glide.with(this@MainActivity)
                    .load(it.photoUrl)
                    .transform(CenterCrop(), RoundedCorners(70))
                    .into(imgMainUser)
            }
        }

        viewModel.getRecommendation().observe(this){
            if (it!=null){
                when(it){
                    is Result.Loading-> {
                        recommendationLoading(true)
                    }
                    is Result.Success ->{
                        val adapter = ListRecommendationAdapter()
                        adapter.submitList(it.data)
                        binding.rvMainRekomendasi.adapter = adapter
                        recommendationLoading(false)
                    }
                    is Result.Error ->{
                        Toast.makeText(this, "Failed load data: ${it.error}!", Toast.LENGTH_SHORT).show()
                        recommendationLoading(false)
                    }
                }
            }
        }

        viewModel.getNearby().observe(this){
            if (it!=null){
                when(it){
                    is Result.Loading-> {
                        nearbyLoading(true)
                    }
                    is Result.Success ->{
                        val adapter = ListNearbyAdapter()
                        adapter.submitList(it.data)
                        binding.rvMainNearby.adapter = adapter
                        nearbyLoading(false)
                    }
                    is Result.Error ->{
                        Toast.makeText(this, "Failed load data: ${it.error}!", Toast.LENGTH_SHORT).show()
                        nearbyLoading(false)
                    }
                }
            }
        }

        viewModel.getFavorite().observe(this){
            if (it!=null){
                when(it){
                    is Result.Loading-> {
                        favoriteLoading(true)
                    }
                    is Result.Success ->{
                        val adapter = ListFavoriteAdapter()
                        adapter.submitList(it.data)
                        binding.rvMainFavorite.adapter = adapter
                        favoriteLoading(false)
                    }
                    is Result.Error ->{
                        Toast.makeText(this, "Failed load data: ${it.error}!", Toast.LENGTH_SHORT).show()
                        favoriteLoading(false)
                    }
                }
            }
        }

        viewModel.setRecommendation()
        viewModel.setNearby(0F, 1F)
        viewModel.setFavorite()

        binding.apply {
            searchView.setupWithSearchBar(sbMain)
            searchView
                .editText
                .setOnEditorActionListener { _, _,_ ->
                    sbMain.setText(searchView.text)
                    searchView.hide()
                    searchView.visibility = View.GONE
                    false
                }
        }
    }

    private fun recommendationLoading(isLoading: Boolean){
        binding.apply {
            if (isLoading){
                pbMainRekomendasi.visibility = View.VISIBLE
                rvMainRekomendasi.visibility = View.INVISIBLE
            } else {
                pbMainRekomendasi.visibility = View.INVISIBLE
                rvMainRekomendasi.visibility = View.VISIBLE
            }
        }
    }

    private fun nearbyLoading(isLoading: Boolean){
        binding.apply {
            if (isLoading){
                pbMainNearby.visibility = View.VISIBLE
                rvMainNearby.visibility = View.INVISIBLE
            } else {
                pbMainNearby.visibility = View.INVISIBLE
                rvMainNearby.visibility = View.VISIBLE
            }
        }
    }

    private fun favoriteLoading(isLoading: Boolean){
        binding.apply {
            if (isLoading){
                pbMainFavorite.visibility = View.VISIBLE
                rvMainFavorite.visibility = View.INVISIBLE
            } else {
                pbMainFavorite.visibility = View.INVISIBLE
                rvMainFavorite.visibility = View.VISIBLE
            }
        }
    }
}