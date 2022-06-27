package com.example.movieapplication.data.repository.tvshow.datasource

import com.example.movieapplication.data.modal.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShow:List<TvShow>)
}