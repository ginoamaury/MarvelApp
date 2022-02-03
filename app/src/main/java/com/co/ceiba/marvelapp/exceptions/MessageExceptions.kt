package com.co.ceiba.marvelapp.exceptions

import android.content.Context
import com.co.ceiba.marvelapp.R

class MessageExceptions (private val context: Context) {
    fun getMessageExceptionByCode (code: Int): String{
        val hashMessage = HashMapExceptionsMessage.getHashCodeMessage(context = context)
        return if( hashMessage.containsKey(code)) hashMessage.getValue(code)
        else context.getString(R.string.default_exception_message)
    }
}

class HashMapExceptionsMessage (){
    companion object {
        fun getHashCodeMessage (context: Context) : HashMap<Int,String> {
            val hashCodeMessage: HashMap<Int,String> = HashMap()
            hashCodeMessage.put(404, context.getString(R.string.no_data_movie_exception_message))
            hashCodeMessage.put(500, context.getString(R.string.technical_exception_message))
            return hashCodeMessage
        }
    }
}