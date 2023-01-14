package com.lenibonje.habari.data.repository

import com.lenibonje.habari.data.model.ApiResponse
import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.data.repository.datasource.NewsRemoteDatasource
import com.lenibonje.habari.data.util.Resource
import com.lenibonje.habari.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDatasource: NewsRemoteDatasource
): NewsRepository {

    private fun responseToResource(response: Response<ApiResponse>): Resource<ApiResponse>{
        if (response.isSuccessful){
            response.body()?.let{ result ->
                return Resource.Success(result)
            }
        }

        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<ApiResponse> {
        return responseToResource(newsRemoteDatasource.getTopHeadLines(country, page))
    }

    override suspend fun getSearchedNewsHeadlines(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<ApiResponse> {
        return responseToResource(newsRemoteDatasource.getSearchedTopHeadLines(country, searchQuery, page))
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}