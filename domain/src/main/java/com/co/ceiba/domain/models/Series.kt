package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Series(
   val available: Int,
   val collectionURI: String,
   val items: List<Serie>,
   val returned: Int
)