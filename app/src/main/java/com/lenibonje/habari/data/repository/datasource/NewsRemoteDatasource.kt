package com.lenibonje.habari.data.repository.datasource

import com.lenibonje.habari.data.model.ApiResponse
import retrofit2.Response

interface NewsRemoteDatasource {

    suspend fun getTopHeadLines(country: String, page: Int): Response<ApiResponse>

}