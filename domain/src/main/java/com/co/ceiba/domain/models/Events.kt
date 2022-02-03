package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Events(
   val available: Int,
   val collectionURI: String,
   val items: List<Event>,
   val returned: Int
)