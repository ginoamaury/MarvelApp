package com.co.ceiba.infrastructure.character.repositories

import com.co.ceiba.domain.exceptions.NoDataCharacterException
import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.repositories.CharacterRemoteRepository
import com.co.ceiba.infrastructure.httpclient.MarvelService
import com.co.ceiba.infrastructure.character.anticorruption.CharacterTranslate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CharacterRetrofitRepository(private val marvelService: MarvelService) : CharacterRemoteRepository {
    override fun getCharacters(): Flow<List<Character>> {
        return flow { emit(marvelService.getAllCharacters()) }.catch {
            //throw NoDataCharacterException()
            exception ->
            println("ERRROOOOR . "+exception.localizedMessage)
        }.map {
            CharacterTranslate.mapCharactersDtoToDomain(it)
        }
    }

    override fun getCharactersByName(name:String): Flow<List<Character>> {
        return flow { emit(marvelService.getCharactersByName(name = name)) }.catch {
            throw NoDataCharacterException()
        }.map {
            CharacterTranslate.mapCharactersDtoToDomain(it)
        }
    }
}