package com.example.chatapp.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class GroupChatRepository {
    private var fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun createGroupChat(
        numberMembers: Int, memberImage: ArrayList<String>, nameMembers: ArrayList<String>,
        listUserId: ArrayList<Int>, nameChat: String, imageChat: String
    ) {
        val collectionRef = fireStore.collection("GroupChat")
        val groupChatMap: MutableMap<String, Any> = HashMap()
        groupChatMap["numberMembers"] = numberMembers
        groupChatMap["memberImage"] = memberImage
        groupChatMap["lastMessage"] = ""
        groupChatMap["lastTime"] = ""
        groupChatMap["nameMembers"] = nameMembers
        groupChatMap["listIdMembers"] = listUserId
        groupChatMap["lastSenderId"] = ""
        groupChatMap["lastSenderName"] = ""
        groupChatMap["nameChat"] = nameChat
        groupChatMap["imageChat"] = imageChat
        collectionRef.document()
            .set(groupChatMap).addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("Create Status ", "Success")
                } else {
                    Log.d("Create Status", " Failure")
                }

            }

    }
}
