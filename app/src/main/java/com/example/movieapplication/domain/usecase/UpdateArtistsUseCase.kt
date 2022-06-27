package com.example.movieapplication.domain.usecase

import com.example.movieapplication.data.modal.artist.Artist
import com.example.movieapplication.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? =artistRepository.updateArtists()

}