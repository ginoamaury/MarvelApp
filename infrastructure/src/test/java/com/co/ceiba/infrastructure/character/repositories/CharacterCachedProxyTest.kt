package com.co.ceiba.infrastructure.character.repositories

import com.co.ceiba.domain.builder.Builder
import com.co.ceiba.domain.repositories.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import com.co.ceiba.domain.models.*
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class CharacterCachedProxyTest {

    @Mock
    private lateinit var localRepository: CharacterLocalRepository

    @Mock
    private lateinit var remoteRepository: CharacterRemoteRepository

    @Mock
    private lateinit var temporalRepository: CharacterTemporalRepository

    @InjectMocks
    private lateinit var characterCachedProxy: CharacterCachedProxy

    private val characters = Builder.getListCharacter()
    private val flowCharacters: Flow<List<Character>> = flow { emit(characters) }
    private val flowCharacter: Flow<Character> = flow { emit(characters[0]) }

    @Test
    fun getCharacters_whenIsLocalRepository_charactersResult() {
        runBlocking {
            //Arrange
            val idCharacter = characters[0].id
            Mockito.`when`(localRepository.getCharacterById(idCharacter)).thenReturn(flowCharacter)
            //Act
            val result = characterCachedProxy.getCharacter(idCharacter)
            //Assert
            Mockito.verify(localRepository, Mockito.times(1)).getCharacterById(idCharacter)
            Assert.assertEquals(flowCharacter, result)
        }
    }

    @Test
    fun getCharacters_whenLocalRepositoryIsEmpty_charactersResultFromRemote() {
        runBlocking {
            //Arrange
            val updateMills = Calendar.getInstance().timeInMillis.toString()
            Mockito.`when`(temporalRepository.getLastUpdatedPreference()).thenReturn(updateMills)
            Mockito.`when`(localRepository.isEmpty()).thenReturn(true)
            Mockito.`when`(remoteRepository.getCharacters()).thenReturn(flowCharacters)
            //Act
            val result = characterCachedProxy.getCharacters()
            //Assert
            Mockito.verify(temporalRepository, Mockito.times(1)).getLastUpdatedPreference()
            Mockito.verify(localRepository, Mockito.times(1)).isEmpty()
            Mockito.verify(localRepository, Mockito.times(0)).getAllCharacters()
            Mockito.verify(remoteRepository, Mockito.times(1)).getCharacters()
            Mockito.verify(localRepository, Mockito.times(1)).insertCharacters(characters)
            Mockito.verify(temporalRepository, Mockito.times(1))
                .saveLastUpdatedPreference(anyString())
            Assert.assertEquals(flowCharacters, result)
        }
    }

    @Test
    fun getCharacters_whenLocalRepositoryIsNotEmptyAndIsUpdated_charactersResultFromLocal() {
        runBlocking {
            //Arrange
            val updateMills = Calendar.getInstance().timeInMillis.toString()
            Mockito.`when`(temporalRepository.getLastUpdatedPreference()).thenReturn(updateMills)
            Mockito.`when`(localRepository.isEmpty()).thenReturn(false)
            Mockito.`when`(localRepository.getAllCharacters()).thenReturn(flowCharacters)
            //Act
            val result = characterCachedProxy.getCharacters()
            //Assert
            Mockito.verify(temporalRepository, Mockito.times(1)).getLastUpdatedPreference()
            Mockito.verify(localRepository, Mockito.times(1)).isEmpty()
            Mockito.verify(localRepository, Mockito.times(1)).getAllCharacters()
            Mockito.verify(remoteRepository, Mockito.times(0)).getCharacters()
            Assert.assertEquals(flowCharacters, result)
        }
    }

    @Test
    fun getCharacters_whenLocalRepositoryIsNotEmptyAndIsNotUpdated_charactersResultFromRemote() {
        runBlocking {
            //Arrange
            val actualDate = Calendar.getInstance().timeInMillis
            val updateMills = actualDate - 3700000
            Mockito.`when`(temporalRepository.getLastUpdatedPreference())
                .thenReturn(updateMills.toString())
            Mockito.`when`(localRepository.isEmpty()).thenReturn(false)
            Mockito.`when`(remoteRepository.getCharacters()).thenReturn(flowCharacters)
            //Act
            val result = characterCachedProxy.getCharacters()
            //Assert
            Mockito.verify(temporalRepository, Mockito.times(1)).getLastUpdatedPreference()
            Mockito.verify(localRepository, Mockito.times(1)).isEmpty()
            Mockito.verify(localRepository, Mockito.times(0)).getAllCharacters()
            Mockito.verify(remoteRepository, Mockito.times(1)).getCharacters()
            Mockito.verify(localRepository, Mockito.times(1)).insertCharacters(characters)
            Mockito.verify(temporalRepository, Mockito.times(1))
                .saveLastUpdatedPreference(anyString())
            Assert.assertEquals(flowCharacters, result)
        }
    }
}