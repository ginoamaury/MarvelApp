package com.co.ceiba.infrastructure.character.repositories

import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.models.Coordinator
import com.co.ceiba.domain.repositories.CharacterLocalRepository
import com.co.ceiba.domain.repositories.CharacterProxy
import com.co.ceiba.domain.repositories.CharacterRemoteRepository
import com.co.ceiba.domain.repositories.CharacterTemporalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import java.util.*

class CharacterCachedProxy(
    private val localRepository: CharacterLocalRepository,
    private val remoteRepository: CharacterRemoteRepository,
    private val temporalRepository: CharacterTemporalRepository
) :
    CharacterProxy {

    override fun getCharacter(id: Int): Flow<Character> = localRepository.getCharacterById(id)

    override suspend fun getCharacters(): Flow<List<Character>> {
        val sharedTime = temporalRepository.getLastUpdatedPreference()
        val isEmptyLocal = localRepository.isEmpty()
        return if (!isEmptyLocal && Coordinator.isUpdated(sharedTime)) {
            localRepository.getAllCharacters()
        } else {
            val response = remoteRepository.getCharacters()
            response.collect { characters ->
                saveCharacters(characters)
            }
            response
        }
    }

    override suspend fun getCharacterByName(name:String): Flow<List<Character>> {
        val sharedTime = temporalRepository.getLastUpdatedPreference()
        val isEmptyLocal = localRepository.isEmpty()
        return if (!isEmptyLocal && Coordinator.isUpdated(sharedTime)) {
            localRepository.getCharactersByName(name)
        } else {
            val response = remoteRepository.getCharactersByName(name)
            response.collect { characters ->
                saveCharacters(characters)
            }
            response
        }
    }

    private suspend fun saveCharacters(characters: List<Character>) {
        localRepository.insertCharacters(characters)
        temporalRepository.saveLastUpdatedPreference(Calendar.getInstance().timeInMillis.toString())
    }

}