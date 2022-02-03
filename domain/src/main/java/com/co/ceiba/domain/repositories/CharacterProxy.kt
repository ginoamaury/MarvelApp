package com.co.ceiba.domain.repositories

import com.co.ceiba.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterProxy {
    fun getCharacter(id:Int): Flow<Character>
    suspend fun getCharacters(): Flow<List<Character>>
    suspend fun getCharacterByName(name:String): Flow<List<Character>>
}