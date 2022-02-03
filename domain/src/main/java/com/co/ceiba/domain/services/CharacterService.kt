package com.co.ceiba.domain.services

import com.co.ceiba.domain.repositories.CharacterProxy

class CharacterService (private val characterProxy: CharacterProxy) {
    operator fun invoke (id:Int) = characterProxy.getCharacter(id)
}