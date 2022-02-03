package com.co.ceiba.marvelapp.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.co.ceiba.domain.builder.Builder
import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.services.CharacterService
import com.co.ceiba.marvelapp.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config


@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class CharacterViewModelTest {

    @get: Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get: Rule
    var coroutineTestRule = CoroutineTestRule()

    @Mock
    lateinit var characterService: CharacterService

    private lateinit var characterViewModel: CharacterViewModel


    @ExperimentalCoroutinesApi
    @Before
    fun start(){
        characterViewModel = CharacterViewModel(characterService = characterService, context = mock(Context::class.java), ioDispatcher = coroutineTestRule.testDispatcher)
    }


    private val flowCharacter: Flow<Character> = Builder.getFlowCharacter()


    @Test
    fun getMovie_whenGetMovie_okResponse() {
        runBlocking {
            //Arrange
            val idCharacter = 10
            Mockito.`when`(characterService.invoke(idCharacter)).thenReturn(flowCharacter)
            //Act
            characterViewModel.getMovie(idCharacter)
            //Assert
            Mockito.verify(characterService, Mockito.times(1)).invoke(idCharacter)
        }
    }

    @Test
    fun getMovie_whenGetMovie_exceptionResponse(){
        runBlocking {
            //Arrange
            val idCharacter = 10
            Mockito.`when`(characterService.invoke(idCharacter)).thenReturn(null)
            //Act
            characterViewModel.getMovie(idCharacter)
            //Assert
            Assert.assertTrue(characterViewModel.uiState.value.error)
        }
    }

}