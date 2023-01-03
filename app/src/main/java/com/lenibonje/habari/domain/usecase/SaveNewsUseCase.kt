package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.domain.repository.NewsRepository

class SaveNewsUseCase(private val repository: NewsRepository) {

    suspend fun execute(article: Article) = repository.saveNews(article)
}