package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val repository: NewsRepository) {

    fun execute(article: Article): Flow<List<Article>> = repository.getSavedNews()

}