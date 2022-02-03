package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg


@NoArg
class Stories(
   val available: Int,
   val collectionURI: String,
   val items: List<Story>,
   val returned: Int
)