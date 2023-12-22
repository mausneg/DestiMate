package com.capstone.destimate.view.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.capstone.destimate.data.local.model.DestinationModel
import com.capstone.destimate.data.repository.Result
import com.capstone.destimate.databinding.ActivityDetailBinding
import com.capstone.destimate.utils.ViewModelFactory
import com.capstone.destimate.view.adapter.ListRecommendationAdapter
import com.capstone.destimate.view.maps.MapsActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var destinationDetail: DestinationModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[DetailViewModel::class.java]
        setContentView(binding.root)

        val destination = if (Build.VERSION.SDK_INT >=33){
            intent.getParcelableExtra(EXTRA_DESTINATION, DestinationModel::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DESTINATION)
        }
        viewModel.setDetail(destination!!)

        val layoutManagerSerupa = LinearLayoutManager(this)
        layoutManagerSerupa.orientation = RecyclerView.HORIZONTAL
        binding.rvDetailSerupa.layoutManager = layoutManagerSerupa

        initView()
        initAction()
    }

    private fun initAction(){
        binding.apply {
            btDetailMap.setOnClickListener{
                startActivity( Intent(this@DetailActivity, MapsActivity::class.java))
            }
        }
    }

    private fun initView(){
        viewModel.getDetail().observe(this){
            setDestinationDetail(it)
            viewModel.setDestinasiSerupa(it.placeId)
        }

        viewModel.getDestinasiSerupa().observe(this){
            if (it!=null){
                when(it){
                    is Result.Loading-> {
//                        recommendationLoading(true)
                    }
                    is Result.Success ->{
                        val adapter = ListRecommendationAdapter()
                        adapter.submitList(it.data)
                        binding.rvDetailSerupa.adapter = adapter
//                        recommendationLoading(false)
                    }
                    is Result.Error ->{
                        Toast.makeText(this, "Failed load data: ${it.error}!", Toast.LENGTH_SHORT).show()
//                        recommendationLoading(false)
                    }
                }
            }
        }

    }

    private fun setDestinationDetail(data: DestinationModel){
        destinationDetail = data
        binding.apply {
            tvDetailName.text = data.placeName
            tvDetailAlamat.text = data.city
            tvDetailRating.text = data.rating.toString()
            tvDetailCategory.text = data.category
            "Rp. ${data.price},.".also { tvDetailBudget.text = it }
            tvDetailDescription.text = data.description

            Glide.with(imgDetailPhoto)
                .load(data.photoUrl)
                .transform(CenterCrop())
                .into(imgDetailPhoto)
        }
    }

    companion object{
        const val EXTRA_DESTINATION = "extra_destination"
    }
}