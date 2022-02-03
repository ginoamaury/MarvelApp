package com.co.ceiba.infrastructure.character.persistence.entity

import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Url


@NoArg
class UrlEntity(
    val type: String,
    val url: String
){
    constructor(url: Url): this(
        type = url.type,
        url = url.url
    )
}