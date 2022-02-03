package com.co.ceiba.infrastructure.dependencyInjection

import com.co.ceiba.domain.repositories.CharacterProxy
import com.co.ceiba.domain.services.CharacterService
import com.co.ceiba.domain.services.CharactersByNameService
import com.co.ceiba.domain.services.CharactersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun getMovies (characterProxy: CharacterProxy) : CharactersService = CharactersService(characterProxy)

    @Provides
    fun getMovie (characterProxy: CharacterProxy) : CharacterService = CharacterService(characterProxy)

    @Provides
    fun getMoviesByName (characterProxy: CharacterProxy) : CharactersByNameService = CharactersByNameService(characterProxy)

}