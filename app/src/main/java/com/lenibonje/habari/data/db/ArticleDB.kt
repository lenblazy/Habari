package com.lenibonje.habari.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lenibonje.habari.data.model.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ArticleDB: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

}