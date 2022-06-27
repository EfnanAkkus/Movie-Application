package com.example.movieapplication.data.repository.artist.datasource

import com.example.movieapplication.data.modal.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}