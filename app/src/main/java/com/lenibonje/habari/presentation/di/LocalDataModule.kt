package com.lenibonje.habari.presentation.di

import com.lenibonje.habari.data.db.ArticleDao
import com.lenibonje.habari.data.repository.datasource.NewsLocalDatasource
import com.lenibonje.habari.data.repository.datasourceImpl.NewsLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDatasource{
        return NewsLocalDatasourceImpl(articleDao)
    }

}