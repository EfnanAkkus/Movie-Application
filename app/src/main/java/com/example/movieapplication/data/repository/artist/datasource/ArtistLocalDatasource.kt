package com.example.movieapplication.data.repository.artist.datasource

import com.example.movieapplication.data.modal.artist.Artist

interface ArtistLocalDatasource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}