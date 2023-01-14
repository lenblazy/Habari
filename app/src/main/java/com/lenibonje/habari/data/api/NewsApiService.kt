package com.lenibonje.habari.data.api

import com.lenibonje.habari.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headLines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = "da18f6f7abae4139b8c88f5b0d17b73e",
    ): Response<ApiResponse>

    @GET("v2/top-headLines")
    suspend fun getSearchedTopHeadlines(
        @Query("country")
        country: String,
        @Query("q")
        searchQuery: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = "da18f6f7abae4139b8c88f5b0d17b73e",
    ): Response<ApiResponse>

}