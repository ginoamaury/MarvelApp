package com.co.ceiba.domain.builder
import com.co.ceiba.domain.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Builder {

    companion object{

        fun getFlowListCharacter (): Flow<List<Character>> {
            val movies = listOf(BuilderCharacter.getCharacter("Spiderman"),BuilderCharacter.getCharacter("Deadpool"))
            return flow { emit(movies) }
        }

        fun getFlowCharacter (): Flow<Character> {
            return flow { emit(BuilderCharacter.getCharacter("Spiderman")) }
        }

        fun getCharacter (): Character = BuilderCharacter.getCharacter("Spiderman")

        fun getListCharacter (): List<Character> = listOf(BuilderCharacter.getCharacter("Spiderman"),BuilderCharacter.getCharacter("Deadpool"))

    }


    private class BuilderCharacter {
        companion object {
            fun getCharacter (name:String): Character {
                if(name == "Spiderman"){
                    return Character (
                        comics = Comics(0,"", listOf(),0),
                        description = "example description",
                        events = Events(0,"", listOf(),0),
                        id = 10,
                        modified = "2021-02-13T1ADCXABKSCN",
                        name = "Spiderman",
                        resourceURI = "",
                        series = Series(0,"", listOf(),0),
                        thumbnail = Thumbnail(extension = "jpg",path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"),
                        urls = listOf(),
                        stories = Stories(0,"", listOf(),0)
                    )
                }else{
                    return Character (
                        comics = Comics(0,"", listOf(),0),
                        description = "example description",
                        events = Events(0,"", listOf(),0),
                        id = 10,
                        modified = "2021-02-13T1ADCXABKSCN",
                        name = "Deadpool",
                        resourceURI = "",
                        series = Series(0,"", listOf(),0),
                        thumbnail = Thumbnail(extension = "jpg",path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"),
                        urls = listOf(),
                        stories = Stories(0,"", listOf(),0)
                    )
                }
            }
        }
    }
}