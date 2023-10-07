package com.example.chatapp.chat.groupchat

import java.util.*
import kotlin.collections.ArrayList

class GroupChat {
    var documentId: String? = null
    var numberMembers: Int? = null
    var memberImage: ArrayList<String>? = null
    var lastMessage: String? = null
    var lastTime: Date? = null
    var nameMembers: ArrayList<String>? = null
    var listUserId: ArrayList<Int>? = null
    var lastSenderId: Int? = null
    var lastSenderName: String? = null
    var nameChat: String? = null
    var imageChat: String? = null

    constructor()
}