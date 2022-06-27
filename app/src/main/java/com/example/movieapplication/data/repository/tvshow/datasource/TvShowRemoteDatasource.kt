package com.example.movieapplication.data.repository.tvshow.datasource

import com.example.movieapplication.data.modal.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}