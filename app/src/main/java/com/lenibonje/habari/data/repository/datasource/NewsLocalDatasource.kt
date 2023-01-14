package com.lenibonje.habari.data.repository.datasource

import com.lenibonje.habari.data.model.Article

interface NewsLocalDatasource {

    suspend fun saveArticleToDB(article: Article)

}