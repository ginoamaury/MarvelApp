package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Event(
   val name: String,
   val resourceURI: String
)