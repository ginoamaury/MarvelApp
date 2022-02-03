package com.co.ceiba.infrastructure.httpclient

import com.co.ceiba.infrastructure.character.httpclient.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Query

private const val QUERY_CHARACTERS = "/v1/public/characters"
private const val QUERY_API_KEY = "apikey"
private const val QUERY_TIMESTAMP = "ts"
private const val QUERY_HASH = "hash"
private const val QUERY_NAME = "nameStartsWith"
private const val API_KEY = "deed983654612887808d63a8bf0dc0a4"
private const val HASH = "64c6a0f2293ad5e79154ea2b67129a67"
interface MarvelService {

    @GET(QUERY_CHARACTERS)
    suspend fun getAllCharacters(
        @Query(QUERY_TIMESTAMP) ts: Int = 1000,
        @Query(QUERY_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_HASH) hash: String = HASH,
    ) : CharactersDto

    @GET(QUERY_CHARACTERS)
    suspend fun getCharactersByName(
        @Query(QUERY_TIMESTAMP) ts: Int = 1000,
        @Query(QUERY_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_HASH) hash: String = HASH,
        @Query(QUERY_NAME) name: String
    ) : CharactersDto

}
