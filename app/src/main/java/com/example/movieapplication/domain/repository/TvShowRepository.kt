package com.example.movieapplication.domain.repository

import com.example.movieapplication.data.modal.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}