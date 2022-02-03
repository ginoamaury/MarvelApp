package com.co.ceiba.domain.repositories

import com.co.ceiba.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterLocalRepository {
    fun isEmpty (): Boolean
    fun characterExist(id: Int): Boolean
    fun getAllCharacters () : Flow<List<Character>>
    fun getCharactersByName(name:String): Flow<List<Character>>
    fun getCharacterById (id:Int) : Flow<Character>
    fun getCountCharacter (): Int
    suspend fun insertCharacters (characters : List<Character>)
}