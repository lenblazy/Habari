package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.data.model.ApiResponse
import com.lenibonje.habari.data.util.Resource
import com.lenibonje.habari.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<ApiResponse> = newsRepository.getNewsHeadlines()

}