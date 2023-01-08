package com.lenibonje.habari.presentation.di

import com.lenibonje.habari.data.api.NewsApiService
import com.lenibonje.habari.data.repository.datasource.NewsRemoteDatasource
import com.lenibonje.habari.data.repository.datasourceImpl.NewsRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsDataSource(newsApiService: NewsApiService): NewsRemoteDatasource {
        return NewsRemoteDatasourceImpl(newsApiService)
    }

}