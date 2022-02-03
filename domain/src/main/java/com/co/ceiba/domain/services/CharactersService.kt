package com.co.ceiba.domain.services

import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.repositories.CharacterProxy
import kotlinx.coroutines.flow.Flow

class CharactersService (private val characterProxy: CharacterProxy) {
     suspend operator fun invoke(): Flow<List<Character>> = characterProxy.getCharacters()
}