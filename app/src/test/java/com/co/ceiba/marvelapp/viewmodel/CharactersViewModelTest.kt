package com.co.ceiba.marvelapp.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.co.ceiba.domain.builder.Builder
import com.co.ceiba.domain.services.CharactersByNameService
import com.co.ceiba.domain.services.CharactersService
import com.co.ceiba.marvelapp.CoroutineTestRule
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class CharactersViewModelTest {

    @get: Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    var coroutineTestRule = CoroutineTestRule()

    @Mock
    lateinit var charactersService: CharactersService

    @Mock
    lateinit var charactersByNameService: CharactersByNameService

    private lateinit var charactersViewModel: CharactersViewModel


    @Before
    fun start(){
        charactersViewModel = CharactersViewModel(charactersService = charactersService,charactersByNameService = charactersByNameService,context = Mockito.mock(Context::class.java), ioDispatcher = coroutineTestRule.testDispatcher)
    }

    @Test
    fun getCharacters_whenCharactersServicesWasCalled_okResponse() {
        runBlocking {
            Mockito.verify(charactersService,Mockito.times(1)).invoke()
        }
    }

    @Test
    fun getCharacters_whenGetCharacters_exceptionResponse(){
        runBlocking {
            //Arrange
            Mockito.`when`(charactersService.invoke()).thenReturn(null)
            //Act
            charactersViewModel.getMovies()
            //Assert
            Assert.assertTrue(charactersViewModel.uiState.value.error)
        }
    }

    @Test
    fun getCharacters_whenGetCharacters_okResponse(){
        runBlocking {
            //Arrange
            Mockito.`when`(charactersService.invoke()).thenReturn(Builder.getFlowListCharacter())
            //Act
            charactersViewModel.getMovies()
            //Assert
            Assert.assertEquals(charactersViewModel.uiState.value.successes[0].name, Builder.getCharacter().name)
        }
    }

}