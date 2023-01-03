package com.lenibonje.habari.domain.usecase

import com.lenibonje.habari.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}