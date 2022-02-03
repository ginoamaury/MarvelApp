package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>,
    val returned: Int
)