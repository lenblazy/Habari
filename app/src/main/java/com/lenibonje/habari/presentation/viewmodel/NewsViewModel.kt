package com.lenibonje.habari.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lenibonje.habari.data.model.ApiResponse
import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.data.util.Resource
import com.lenibonje.habari.domain.usecase.GetNewsHeadlinesUseCase
import com.lenibonje.habari.domain.usecase.GetSearchedNewsUseCase
import com.lenibonje.habari.domain.usecase.SaveNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase
    ): AndroidViewModel(app) {

    val newsHeadLines: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())

        try {
            if (isInternetAvailable(app)) {
                val apiResponse = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadLines.postValue(apiResponse)
            } else {
                newsHeadLines.postValue(Resource.Error("Internet not available"))
            }
        }catch (e: Exception){
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }
    }

    //search
    val searchedNews: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()

    fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ) = viewModelScope.launch(Dispatchers.IO) {
        searchedNews.postValue(Resource.Loading())

        try {
            if (isInternetAvailable(app)) {
                val apiResponse = getSearchedNewsUseCase.execute(country, searchQuery, page)
                searchedNews.postValue(apiResponse)
            } else {
                searchedNews.postValue(Resource.Error("Internet not available"))
            }
        }catch (e: Exception){
            searchedNews.postValue(Resource.Error(e.message.toString()))
        }
    }

    @Suppress("DEPRECATION")
    fun isInternetAvailable(context: Context): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        result = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        result = true
                    }
                }
            }
        }
        return result
    }

    //local database
    fun saveArticle(article: Article) = viewModelScope.launch {

    }

}