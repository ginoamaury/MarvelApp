package com.co.ceiba.infrastructure.character.persistence.entity

import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Story

@NoArg
class StoryEntity(
   val name: String,
   val resourceURI: String,
   val type: String
){
   constructor(story: Story): this(
      name = story.name,
      resourceURI = story.resourceURI,
      type = story.type
   )
}