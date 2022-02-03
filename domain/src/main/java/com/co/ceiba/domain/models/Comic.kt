package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Comic(
     val name: String,
     val resourceURI: String
)