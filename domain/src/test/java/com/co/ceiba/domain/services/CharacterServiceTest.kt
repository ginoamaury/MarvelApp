package com.co.ceiba.domain.services

import com.co.ceiba.domain.builder.Builder
import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.repositories.CharacterProxy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterServiceTest {

    @Mock
    lateinit var characterProxy : CharacterProxy

    @InjectMocks
    lateinit var characterService: CharacterService

    private val character = Builder.getCharacter()

    private val flowMovie: Flow<Character> = Builder.getFlowCharacter()

    @Test
    fun movieService_whenIsInvoked_movieResponse(){
        runBlocking {
            //Arrange
            val idCharacter = character.id
            Mockito.`when`(characterProxy.getCharacter(idCharacter)).thenReturn(flowMovie)
            //Act
            val result = characterService.invoke(idCharacter)
            //Assert
            Mockito.verify(characterProxy,Mockito.times(1)).getCharacter(idCharacter)
            Assert.assertEquals(flowMovie,result)
        }

    }

}