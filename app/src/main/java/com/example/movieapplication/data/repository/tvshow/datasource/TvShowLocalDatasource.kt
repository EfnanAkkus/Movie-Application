package com.example.movieapplication.data.repository.tvshow.datasource

import com.example.movieapplication.data.modal.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}