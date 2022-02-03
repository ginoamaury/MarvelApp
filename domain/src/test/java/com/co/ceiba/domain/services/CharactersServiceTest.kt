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
class CharactersServiceTest {

    @Mock
    lateinit var characterProxy : CharacterProxy

    @InjectMocks
    lateinit var charactersService: CharactersService

    private val flowCharacter: Flow<List<Character>> = Builder.getFlowListCharacter()

    @Test
    fun moviesService_whenIsInvoked_moviesResponse(){
        runBlocking {
            //Arrange
            Mockito.`when`(characterProxy.getCharacters()).thenReturn(flowCharacter)
            //Act
            val result = charactersService.invoke()
            //Assert
            Mockito.verify(characterProxy, Mockito.times(1)).getCharacters()
            Assert.assertEquals(flowCharacter,result)
        }

    }

}