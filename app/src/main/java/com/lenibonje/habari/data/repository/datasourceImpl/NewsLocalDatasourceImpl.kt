package com.lenibonje.habari.data.repository.datasourceImpl

import com.lenibonje.habari.data.db.ArticleDao
import com.lenibonje.habari.data.model.Article
import com.lenibonje.habari.data.repository.datasource.NewsLocalDatasource

class NewsLocalDatasourceImpl(private val dao: ArticleDao) : NewsLocalDatasource {

    override suspend fun saveArticleToDB(article: Article) {
        dao.insert(article)
    }

}