package com.co.ceiba.infrastructure.character.persistence.entity

import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Event

@NoArg
class EventEntity(
   val name: String,
   val resourceURI: String
){
   constructor(event: Event): this(
      name = event.name,
      resourceURI = event.resourceURI
   )
}