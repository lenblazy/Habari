package com.lenibonje.habari.presentation.di

import com.lenibonje.habari.domain.repository.NewsRepository
import com.lenibonje.habari.domain.usecase.GetNewsHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadLinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }


}