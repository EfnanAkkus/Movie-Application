package com.example.movieapplication.presentation.di

import ArtistCacheDatasourceImpl
import TvShowCacheDatasourceImpl
import com.example.movieapplication.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.movieapplication.data.repository.movie.datasource.MovieCacheDatasource
import com.example.movieapplication.data.repository.movie.datasourceImp.MovieCacheDatasourceImpl
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.movieapplication.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.movieapplication.data.repository.tvshow.datasourceImp.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }
    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDatasource{
        return TvShowCacheDatasourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }
}