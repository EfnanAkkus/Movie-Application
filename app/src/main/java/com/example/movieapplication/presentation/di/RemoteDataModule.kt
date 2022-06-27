package com.example.movieapplication.presentation.di

import ArtistRemoteDatasourceImpl
import TvShowRemoteDatasourceImpl
import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.movieapplication.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.movieapplication.data.repository.movie.datasourceImp.MovieRemoteDatasourceImpl
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }
    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }
}