package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Thumbnail(
    val extension: String,
    val path: String
)