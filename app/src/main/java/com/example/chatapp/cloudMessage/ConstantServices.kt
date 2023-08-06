package com.example.chatapp.cloudMessage

import kotlin.collections.HashMap

class ConstantServices {
     val remoteAuthorization = "Authorization"
     val remoteContentType = "Content-Type"
     val remoteData = "data"
     val registrationId = "registration_ids"
     var remoteMsgHeaders : HashMap<String, String>? = null
     fun getRemoteMessageHeaders(): HashMap<String,String>{
         if(remoteMsgHeaders == null){
             remoteMsgHeaders = HashMap()
             remoteMsgHeaders!![remoteAuthorization] = "key=AAAABFm-XQ4:APA91bEDOXAObf7E6KjcgRKcb3fBtHMSE3NlZEYuWr0JtcbK7fpxLtdFyXiU8IBpFQHWGpMYMfEUA9p6qMYSx71n9C6ZjNErvJQC-Yejb6l_c2LF6iNmLqkPz8-rp30ZxMtljKZ6-K63"
             remoteMsgHeaders!![remoteContentType] = "application/json"
         }
         return remoteMsgHeaders!!
     }

}