package com.co.ceiba.marvelapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.co.ceiba.domain.exceptions.NoDataCharacterException
import com.co.ceiba.domain.exceptions.TechnicalException
import com.co.ceiba.domain.models.Character
import com.co.ceiba.domain.services.CharacterService
import com.co.ceiba.infrastructure.dependencyInjection.IoDispatcher
import com.co.ceiba.marvelapp.exceptions.MessageExceptions
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val characterService: CharacterService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val loading = MutableStateFlow(CharacterUiState().loading)
    private val success = MutableStateFlow(CharacterUiState().success)
    private val error = MutableStateFlow(CharacterUiState().error)
    private val message = MutableStateFlow(CharacterUiState().message)

    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> get() = _uiState

    init {
        viewModelScope.launch {
            combine(
                loading,
                success,
                error,
                message
            ) { loading, success, error, message ->
                CharacterUiState(loading, success, error,message)
            }.catch { throwable ->
                throw throwable
            }.collect {
                _uiState.value = it
            }
        }
    }

    fun getMovie(id: Int) {
        viewModelScope.launch(ioDispatcher) {
            loading.value = true
            try {
                characterService.invoke(id).collect { character ->
                    success.value = character
                    loading.value = false
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = true
                if(e is NoDataCharacterException) message.value = MessageExceptions(context).getMessageExceptionByCode(e.codeMessage)
                else if (e is TechnicalException) message.value = MessageExceptions(context).getMessageExceptionByCode(e.codeMessage)
            }
        }
    }

}


data class CharacterUiState(
    var loading: Boolean = false,
    var success: Character? = null,
    var error: Boolean = false,
    var message: String = ""
)
