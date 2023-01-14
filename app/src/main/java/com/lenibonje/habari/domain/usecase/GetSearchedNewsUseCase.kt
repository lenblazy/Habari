package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.data.model.ApiResponse
import com.lenibonje.habari.data.util.Resource
import com.lenibonje.habari.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val repository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<ApiResponse> =
        repository.getSearchedNewsHeadlines(country, searchQuery, page)


}