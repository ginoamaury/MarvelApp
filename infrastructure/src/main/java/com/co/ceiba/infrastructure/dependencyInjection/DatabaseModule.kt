package com.co.ceiba.infrastructure.dependencyInjection

import android.app.Application
import androidx.room.Room
import com.co.ceiba.infrastructure.character.persistence.dao.CharacterDao
import com.co.ceiba.infrastructure.persistence.MarvelDatabase
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
    fun databaseProvider(app: Application): MarvelDatabase = Room.databaseBuilder(
        app,
        MarvelDatabase::class.java,
        "marvel-db"
    ).build()

    @Provides
    fun providesMovieDao (database: MarvelDatabase) : CharacterDao = database.characterDao()

}