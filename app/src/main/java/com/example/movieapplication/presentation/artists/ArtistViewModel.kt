package com.example.movieapplication.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapplication.domain.usecase.GetArtistsUseCase
import com.example.movieapplication.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
   private val getArtistsUseCase: GetArtistsUseCase,
   private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {
    fun getArtists()= liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }
    fun updateArtists()= liveData {
        val artistsList=updateArtistsUseCase.execute()
        emit(artistsList)
    }
}