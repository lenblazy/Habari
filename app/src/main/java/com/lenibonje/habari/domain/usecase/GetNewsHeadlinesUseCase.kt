package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}