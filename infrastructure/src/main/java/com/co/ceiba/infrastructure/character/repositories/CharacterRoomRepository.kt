package com.co.ceiba.infrastructure.character.repositories

import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.repositories.CharacterLocalRepository
import com.co.ceiba.infrastructure.character.anticorruption.CharacterTranslate
import com.co.ceiba.infrastructure.character.persistence.dao.CharacterDao
import com.co.ceiba.infrastructure.character.persistence.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRoomRepository(private val characterDao: CharacterDao) : CharacterLocalRepository {
    override fun isEmpty(): Boolean {
        return getCountCharacter() <= 0
    }

    override fun characterExist(id: Int): Boolean {
        return characterDao.characterExist(id) > 0
    }

    override fun getAllCharacters(): Flow<List<Character>> {
        return characterDao.getAllCharacters()
            .map { movies -> movies.map { CharacterTranslate.mapCharacterEntityToDomain(it) } }
    }

    override fun getCharactersByName(name: String): Flow<List<Character>> {
        return characterDao.getCharactersByName(name)
            .map { movies -> movies.map { CharacterTranslate.mapCharacterEntityToDomain(it) } }
    }

    override fun getCharacterById(id: Int): Flow<Character> {
        return characterDao.getCharacterById(id)
            .map { movie -> CharacterTranslate.mapCharacterEntityToDomain(movie) }
    }

    override fun getCountCharacter(): Int {
        return characterDao.getCountCharacters()
    }

    override suspend fun insertCharacters(characters: List<Character>) {
        characterDao.insertCharacter(characters.map { CharacterEntity(it) })
    }
}