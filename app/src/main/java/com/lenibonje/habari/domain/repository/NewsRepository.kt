package com.lenibonje.habari.domain.repository

import com.lenibonje.habari.data.model.ApiResponse
import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<ApiResponse>
    suspend fun getSearchedNewsHeadlines(country: String, searchQuery: String, page: Int): Resource<ApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>


}