package com.lenibonje.habari.presentation.di

import android.app.Application
import androidx.room.Room
import com.lenibonje.habari.data.db.ArticleDB
import com.lenibonje.habari.data.db.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): ArticleDB {
        return Room.databaseBuilder(app, ArticleDB::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(articleDB: ArticleDB): ArticleDao {
        return articleDB.getArticleDao()
    }


}