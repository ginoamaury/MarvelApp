package com.co.ceiba.domain.exceptions

import java.lang.Exception

private const val NO_DATA_CHARACTER_EXCEPTION_CODE = 404

abstract class MarvelException (message: String) : Exception(message)
class NoDataCharacterException(val codeMessage: Int = NO_DATA_CHARACTER_EXCEPTION_CODE) : MarvelException(codeMessage.toString())


