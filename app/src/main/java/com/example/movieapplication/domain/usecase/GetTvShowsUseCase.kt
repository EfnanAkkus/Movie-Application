package com.example.movieapplication.domain.usecase

import com.example.movieapplication.data.modal.tvshow.TvShow
import com.example.movieapplication.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? =tvShowRepository.getTvShows()

}