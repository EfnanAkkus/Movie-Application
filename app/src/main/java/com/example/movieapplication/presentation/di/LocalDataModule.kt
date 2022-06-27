package com.example.movieapplication.presentation.di

import com.example.movieapplication.data.db.ArtistDao
import com.example.movieapplication.data.db.MovieDao
import com.example.movieapplication.data.db.TvShowDao
import com.example.movieapplication.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.movieapplication.data.repository.movie.datasource.MovieLocalDatasource
import com.example.movieapplication.data.repository.movie.datasourceImp.ArtistLocalDatasourceImpl
import com.example.movieapplication.data.repository.movie.datasourceImp.MovieLocalDatasourceImpl
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.movieapplication.data.repository.tvshow.datasourceImp.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }
}