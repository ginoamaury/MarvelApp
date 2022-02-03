package com.co.ceiba.infrastructure.character.persistence.entity

import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Comic

@NoArg
class ComicEntity(
     val name: String,
     val resourceURI: String
){
     constructor(comic: Comic) : this(
          name = comic.name,
          resourceURI = comic.resourceURI
     )
}