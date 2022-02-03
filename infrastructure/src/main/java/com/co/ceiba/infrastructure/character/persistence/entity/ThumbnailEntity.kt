package com.co.ceiba.infrastructure.character.persistence.entity

import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Thumbnail

@NoArg
class ThumbnailEntity(
    val extension: String,
    val path: String
){
    constructor(thumbnail: Thumbnail): this(
        extension = thumbnail.extension,
        path = thumbnail.path
    )
}