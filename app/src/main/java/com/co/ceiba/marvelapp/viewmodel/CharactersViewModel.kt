package com.co.ceiba.marvelapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.co.ceiba.domain.exceptions.NoDataCharacterException
import com.co.ceiba.domain.exceptions.TechnicalException
import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.services.CharactersByNameService
import com.co.ceiba.domain.services.CharactersService
import com.co.ceiba.infrastructure.dependencyInjection.DefaultDispatcher
import com.co.ceiba.marvelapp.exceptions.MessageExceptions
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val charactersService: CharactersService,
    private val charactersByNameService: CharactersByNameService,
    @DefaultDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val loading = MutableStateFlow(CharactersUiState().loading)
    private val success = MutableStateFlow(CharactersUiState().successes)
    private val error = MutableStateFlow(CharactersUiState().error)
    private val message = MutableStateFlow(CharactersUiState().message)

    private val _uiState = MutableStateFlow(CharactersUiState())
    val uiState: StateFlow<CharactersUiState> get() = _uiState

    init {
        viewModelScope.launch {
            combine(
                loading,
                success,
                error,
                message
            ) { loading, success, error, message ->
                CharactersUiState(loading, success, error, message)
            }.catch { throwable ->
                throw throwable
            }.collect {
                _uiState.value = it
            }
        }
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch(ioDispatcher) {
            loading.value = true
             try {
                charactersService.invoke().collect { characters ->
                    success.value = characters
                    loading.value = false
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = true
                if(e is NoDataCharacterException) message.value = MessageExceptions(context).getMessageExceptionByCode(e.codeMessage)
                else if (e is TechnicalException) message.value = MessageExceptions(context).getMessageExceptionByCode(e.codeMessage)
                println(message.value)
            }

        }
    }

    fun getMoviesByName(name:String){
        viewModelScope.launch(ioDispatcher) {
            loading.value = true
            try {
            charactersByNameService.invoke(name).collect { characters ->
                success.value = characters
                loading.value = false
            }
            } catch (e: Exception) {
                loading.value = false
                error.value = true
                if(e is NoDataCharacterException) message.value = MessageExceptions(context).getMessageExceptionByCode(e.codeMessage)
                else if (e is TechnicalException) message.value = MessageExceptions(context).getMessageExceptionByCode(e.codeMessage)
                println(message.value)
            }

        }
    }

}


data class CharactersUiState(
    var loading: Boolean = false,
    var successes: List<Character> = emptyList(),
    var error: Boolean = false,
    var message: String = ""
)


