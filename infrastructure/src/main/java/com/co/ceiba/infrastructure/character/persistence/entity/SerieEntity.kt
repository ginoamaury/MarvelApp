package com.co.ceiba.infrastructure.character.persistence.entity

import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Serie

@NoArg
class SerieEntity(
    val name: String,
    val resourceURI: String
){
    constructor(serie: Serie): this(
        name = serie.name,
        resourceURI = serie.resourceURI
    )
}