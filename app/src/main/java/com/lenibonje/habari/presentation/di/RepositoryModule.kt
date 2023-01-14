package com.lenibonje.habari.presentation.di

import com.lenibonje.habari.data.repository.NewsRepositoryImpl
import com.lenibonje.habari.data.repository.datasource.NewsLocalDatasource
import com.lenibonje.habari.data.repository.datasource.NewsRemoteDatasource
import com.lenibonje.habari.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDatasource: NewsRemoteDatasource,
        localDatasource: NewsLocalDatasource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDatasource, localDatasource)
    }

}