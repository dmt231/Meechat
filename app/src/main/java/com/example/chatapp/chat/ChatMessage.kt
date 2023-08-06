package com.example.chatapp.chat

import java.util.Date

class ChatMessage {
    var documentId : String? = null
    var chatId : String? = null
    var conversionId : String? = null
    var conversionImage : String? = null
    var conversionName : String? =null
    var conversionNickname : String? = null
    var lastId : Long? = null
    var isSeen : Long? = null
    var isImage : Long? = null
    private var senderID : Long? = null
    private var receivedID : Long? = null
    private var message : String? = null
    private var dateTime : String? = null
    var dateObject : Date? = null
    constructor(senderID : Long, receivedID : Long, message : String, dateTime : String, date: Date){
        this.senderID = senderID
        this.receivedID = receivedID
        this.message = message
        this.dateTime = dateTime
        this.dateObject = date
    }

    constructor(senderID: Long, receivedID: Long, conversionImage : String, conversionName : String, conversionId : String, lastMessage : String, dateObject : Date, lastId : Long ){
        this.senderID = senderID
        this.receivedID = receivedID
        this.conversionImage = conversionImage
        this.conversionName = conversionName
        this.conversionId = conversionId
        this.message = lastMessage
        this.dateObject = dateObject
        this.lastId = lastId
    }
    fun setMessage(message: String){
        this.message = message
    }

    fun getSenderID() : Long{
        return senderID!!
    }
    fun getReceivedID() : Long{
        return receivedID!!
    }
    fun getMessage() : String{
        return message!!
    }
    fun getDatetime() : String{
        return dateTime!!
    }
    constructor()
}