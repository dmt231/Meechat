package com.example.chatapp.chat.groupchat

import java.util.*

class GroupChatMessage {
    var date : Date? = null
    var isImage : Int? = null
    var message : String? = null
    var senderId : Int? = null
    var groupReceived : Int? = null
    var senderImage : String? = null

    constructor(date : Date, isImage : Int, message : String, senderId : Int, groupReceived : Int, senderImage : String){
        this.date = date
        this.isImage = isImage
        this.message = message
        this.senderId = senderId
        this.groupReceived = groupReceived
        this.senderImage = senderImage
    }
    constructor()
}