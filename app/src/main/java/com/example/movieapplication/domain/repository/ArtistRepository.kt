package com.example.movieapplication.domain.repository

import com.example.movieapplication.data.modal.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}