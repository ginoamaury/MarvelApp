package com.co.ceiba.domain.repositories

import com.co.ceiba.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRemoteRepository {
     fun getCharacters(): Flow<List<Character>>
     fun getCharactersByName(name:String): Flow<List<Character>>
}