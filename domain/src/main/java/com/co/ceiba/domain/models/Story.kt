package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Story(
    val name: String,
    val resourceURI: String,
    val type: String
)