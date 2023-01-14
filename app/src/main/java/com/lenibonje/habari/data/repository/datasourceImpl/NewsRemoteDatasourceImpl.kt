package com.lenibonje.habari.data.repository.datasourceImpl

import com.lenibonje.habari.data.api.NewsApiService
import com.lenibonje.habari.data.model.ApiResponse
import com.lenibonje.habari.data.repository.datasource.NewsRemoteDatasource
import retrofit2.Response

class NewsRemoteDatasourceImpl(
    private val newsApiService: NewsApiService
) : NewsRemoteDatasource {

    override suspend fun getTopHeadLines(country: String, page: Int): Response<ApiResponse> {
        return newsApiService.getTopHeadlines(country, page)
    }

    override suspend fun getSearchedTopHeadLines(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<ApiResponse> {
        return newsApiService.getSearchedTopHeadlines(country, searchQuery, page)
    }

}