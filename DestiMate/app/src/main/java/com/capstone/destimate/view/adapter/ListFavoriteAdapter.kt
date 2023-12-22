package com.capstone.destimate.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.capstone.destimate.data.local.model.DestinationModel
import com.capstone.destimate.data.remote.response.Destination
import com.capstone.destimate.databinding.ItemFavoriteBinding
import com.capstone.destimate.view.detail.DetailActivity

class ListFavoriteAdapter: ListAdapter<Destination, ListFavoriteAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val destination = getItem(position)
        holder.bind(destination)
    }

    class MyViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(destination: Destination){
            binding.apply {
                tvItemFavName.text = destination.placeName
                tvItemAlamat.text = destination.city
                tvItemRating.text = destination.rating.toString()
                tvItemDescription.text = destination.description

                Glide.with(imgItemFavPhoto.context)
                    .load(destination.photoUrl)
                    .transform(CenterCrop())
                    .into(imgItemFavPhoto)

                val destinationParcel = DestinationModel(
                    destination.category,
                    destination.city,
                    destination.description,
                    destination.lat,
                    destination.long,
                    destination.photoUrl,
                    destination.placeId,
                    destination.placeName,
                    destination.price,
                    destination.rating,
                    destination.ratingCount
                )

                cvItemFavorite.setOnClickListener{
                    val intentDetail = Intent(cvItemFavorite.context, DetailActivity::class.java)
                    intentDetail.putExtra("extra_destination", destinationParcel)
                    cvItemFavorite.context.startActivity(intentDetail)
                }
            }
        }
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Destination>(){
            override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean {
                return oldItem == newItem
            }
        }
    }
}