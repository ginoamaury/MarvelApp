package com.co.ceiba.domain.models

import com.co.ceiba.domain.anotations.NoArg
import java.util.*

@NoArg
class Coordinator {
    companion object {
        private const val millisPerDay = 3600000
        fun isUpdated(storeDate: String): Boolean {
            val actualDate = Calendar.getInstance().timeInMillis
            return if (storeDate.isNotEmpty()) {
                (actualDate - storeDate.toLong()) <= millisPerDay
            } else {
                false
            }
        }
    }
}