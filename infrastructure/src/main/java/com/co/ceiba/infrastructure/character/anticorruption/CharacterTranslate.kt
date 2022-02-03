package com.co.ceiba.infrastructure.character.anticorruption

import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.models.Comic
import com.co.ceiba.domain.models.Comics
import com.co.ceiba.infrastructure.character.httpclient.dto.CharacterDto
import com.co.ceiba.infrastructure.character.httpclient.dto.CharactersDto
import com.co.ceiba.infrastructure.character.persistence.entity.CharacterEntity
import com.co.ceiba.infrastructure.character.persistence.entity.ComicEntity
import com.co.ceiba.infrastructure.character.persistence.entity.ComicsEntity

class CharacterTranslate {
    companion object {
        fun mapCharacterEntityToDomain(characterEntity: CharacterEntity): Character {
            return Mapper.convert(characterEntity)
        }

        private fun mapCharacterDtoToDomain(characterDto: CharacterDto): Character {
            return Mapper.convert(characterDto)
        }

        fun mapCharactersDtoToDomain(charactersDto: CharactersDto): List<Character> {
            return charactersDto.dataDto.charactersDto.map { mapCharacterDtoToDomain(it) }
        }

        ///START
        private fun mapComicDomainToEntity(comic: Comic): ComicEntity {
            return Mapper.convert(comic)
        }

        fun mapComicsDomainToEntity(comics: Comics): ComicsEntity{
            return Mapper.convert(comics)
        }



        //END

        fun mapCharacterDomainToEntity(character: Character): CharacterEntity{
            return Mapper.convert(character)
        }

    }
}


