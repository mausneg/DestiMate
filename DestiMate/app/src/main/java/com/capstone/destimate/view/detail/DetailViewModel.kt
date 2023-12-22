package com.capstone.destimate.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.destimate.data.local.model.DestinationModel
import com.capstone.destimate.data.repository.DestinationRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val destinationRepository: DestinationRepository): ViewModel() {

    fun setDetail(data: DestinationModel){
        destinationRepository.setDestinationDetail(data)
    }

    fun setDestinasiSerupa(placeId:Int) = viewModelScope.launch {
        destinationRepository.setDestinasiSerupa(placeId)
    }

    fun getDetail() = destinationRepository.getDestinationDetail()

    fun getDestinasiSerupa() = destinationRepository.getDestinasiSerupa()
}