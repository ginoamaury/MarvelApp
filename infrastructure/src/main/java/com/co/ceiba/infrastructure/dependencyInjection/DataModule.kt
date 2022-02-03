package com.co.ceiba.infrastructure.dependencyInjection

import android.content.SharedPreferences
import com.co.ceiba.domain.repositories.CharacterProxy
import com.co.ceiba.domain.repositories.CharacterLocalRepository
import com.co.ceiba.domain.repositories.CharacterTemporalRepository
import com.co.ceiba.domain.repositories.CharacterRemoteRepository
import com.co.ceiba.infrastructure.httpclient.MarvelService
import com.co.ceiba.infrastructure.character.persistence.dao.CharacterDao
import com.co.ceiba.infrastructure.character.repositories.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesRepository(
        localRepository: CharacterLocalRepository,
        remoteRepository: CharacterRemoteRepository,
        temporalRepository: CharacterTemporalRepository
    ): CharacterProxy =
        CharacterCachedProxy(localRepository, remoteRepository, temporalRepository)

    @Provides
    fun providesLocalSource(characterDao: CharacterDao): CharacterLocalRepository =
        CharacterRoomRepository(characterDao)

    @Provides
    fun providesRemoteSource(moviesService: MarvelService): CharacterRemoteRepository =
        CharacterRetrofitRepository(moviesService)

    @Provides
    fun providesPreferencesRepository(sharedPreferences: SharedPreferences): CharacterTemporalRepository = CharacterSharedPreferencesRepository(sharedPreferences)

}