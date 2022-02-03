package com.co.ceiba.infrastructure.character.anticorruption

import com.co.ceiba.domain.models.*
import com.co.ceiba.infrastructure.character.httpclient.dto.*
import com.co.ceiba.infrastructure.character.persistence.entity.CharacterEntity
import com.co.ceiba.infrastructure.character.persistence.entity.ThumbnailEntity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterTranslateTest {

    private val characterTranslate = CharacterTranslate

    private val characterEntity = CharacterEntity(
        description = "example description",
        id = 10,
        modified = "",
        name = "Spiderman",
        resourceURI = "",
        thumbnail = ThumbnailEntity(extension = "jpg",path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73")
    )

    private val characterDto = CharacterDto(
        comics = ComicsDto(0,"", listOf(),0),
        description = "example description",
        events = EventsDto(0,"", listOf(),0),
        id = 10,
        modified = "",
        name = "Spiderman",
        resourceURI = "",
        series = SeriesDto(0,"", listOf(),0),
        thumbnail = ThumbnailDto(extension = "jpg",path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"),
        urls = listOf(),
        stories = StoriesDto(0,"", listOf(),0)
    )

    private val charactersList= listOf(characterDto)

    private val charactersDto = CharactersDto(
        attributionHTML = "test",
        attributionText = "test",
        code = 0,
        copyright = "test",
        dataDto = DataDto(0,0,0,charactersList,0),
        etag = "test",
        status = "test"
    )

    @Test
    fun mapCharacter_WhenEntityToDomain_CharacterReturn(){
        //Arrange
        val character = characterEntity
        //Act
        val result = characterTranslate.mapCharacterEntityToDomain(character)
        //Assert
        Assert.assertTrue(result.javaClass == Character::class.java)
    }

    @Test
    fun mapCharacter_WhenCharacterDtoToDomain_CharacterReturn(){
        //Arrange
        val character = charactersDto
        //Act
        val result = characterTranslate.mapCharactersDtoToDomain(character)[0]
        //Assert
        Assert.assertTrue(result.javaClass == Character::class.java)
    }

}