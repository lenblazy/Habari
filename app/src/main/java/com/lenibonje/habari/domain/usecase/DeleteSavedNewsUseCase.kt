package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val repository: NewsRepository) {

    suspend fun execute(article: Article) = repository.deleteNews(article)

}