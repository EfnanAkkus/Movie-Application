package com.example.movieapplication.data.repository.artist.datasource

import com.example.movieapplication.data.modal.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}