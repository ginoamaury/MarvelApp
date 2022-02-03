package com.co.ceiba.domain.services

import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.repositories.CharacterProxy
import kotlinx.coroutines.flow.Flow

class CharactersByNameService (private val characterProxy: CharacterProxy) {
    suspend operator fun invoke(name:String): Flow<List<Character>> = characterProxy.getCharacterByName(name)
}