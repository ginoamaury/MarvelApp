package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg

@NoArg
class Url(
     val type: String,
     val url: String
)