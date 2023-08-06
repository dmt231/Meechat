package com.example.chatapp.repository

import android.util.Log
import com.example.chatapp.chat.ChatMessage
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ChatRepository {

    private var fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
    fun sendMessage(senderId: Long, receivedId: Long, message: String, date: Date, isImage : Long) {
        val collectionRef = fireStore.collection("Chat")
        val chatMap: MutableMap<String, Any> = HashMap()
        chatMap["senderID"] = senderId
        chatMap["receivedID"] = receivedId
        chatMap["message"] = message
        chatMap["date"] = date
        chatMap["isImage"] = isImage
        collectionRef.document()
            .set(chatMap).addOnCompleteListener {
                if(it.isSuccessful){
                    Log.d("Stats : ", "Chat Success")
                }
                else{
                    Log.d("Error : ", it.exception.toString())
                }
            }
    }



    fun getChat(senderId: Long, receivedId: Long, listChat: ArrayList<ChatMessage>, status: GetChatStatus) {
        val eventListener: EventListener<QuerySnapshot> = EventListener { value, _ ->
            if (value != null) {
                val count = listChat.size
                for (documentChange in value.documentChanges) {
                    if (documentChange.type == DocumentChange.Type.ADDED) {
                        val chatId = documentChange.document.id
                        val senderIdValue = documentChange.document.getLong("senderID")
                        val receivedIdValue = documentChange.document.getLong("receivedID")
                        val message = documentChange.document.getString("message")
                        val dateTime = getReadableDateTime(documentChange.document.getDate("date")!!)
                        val dateObject = documentChange.document.getDate("date")
                        val isImage = documentChange.document.getLong("isImage")
                        val chatMessage = ChatMessage(
                            senderIdValue!!,
                            receivedIdValue!!,
                            message!!,
                            dateTime,
                            dateObject!!
                        )
                        chatMessage.isImage = isImage
                        chatMessage.chatId = chatId
                        listChat.add(chatMessage)
                    }
                }
                listChat.sortWith { obj1, obj2 ->
                    obj1.dateObject!!.compareTo(obj2.dateObject)
                }
                if (count == 0) {
                    status.RecentMessage()
                } else {
                    status.newMessage()
                }
            }
            if(value == null){
                status.noMessage()
            }

        }

        val query = fireStore.collection("Chat")
            .whereIn("senderID", listOf(senderId, receivedId))
            .whereIn("receivedID", listOf(senderId, receivedId))

        query.addSnapshotListener(eventListener)
    }
    fun getImageStorage(senderId: Long, receivedId: Long, listImage : ArrayList<ChatMessage>, getChatStatus: GetChatStatus){
        val eventListener : EventListener<QuerySnapshot> = EventListener { value, _ ->
            if(value != null){
                val count = listImage.size
                for (documentChange in value.documentChanges) {
                    if (documentChange.type == DocumentChange.Type.ADDED) {
                        val message = documentChange.document.getString("message")
                        val dateObject = documentChange.document.getDate("date")
                        val chatMessageImage = ChatMessage()
                        chatMessageImage.setMessage(message!!)
                        chatMessageImage.dateObject = dateObject!!
                        listImage.add(chatMessageImage)
                    }
                }
                listImage.sortWith{ obj1, obj2 ->
                    obj2.dateObject!!.compareTo(obj1.dateObject!!)
                }
                if (count == 0) {
                    getChatStatus.RecentMessage()
                } else {
                    getChatStatus.newMessage()
                }
            }
        }
        val query = fireStore.collection("Chat")
            .whereIn("senderID", listOf(senderId, receivedId))
            .whereIn("receivedID", listOf(senderId, receivedId))
            .whereEqualTo("isImage", 1)
        query.addSnapshotListener(eventListener)
    }
     fun deleteChat(chatId : String){
        val collectionRef = fireStore.collection("Chat")
        collectionRef.document(chatId)
            .get().addOnCompleteListener {
                if(it.isSuccessful){
                    val document = it.result
                    if(document != null && document.exists()){
                        document.reference.delete()
                            .addOnSuccessListener {
                                Log.d("Remove state", "Success")
                            }
                            .addOnFailureListener{
                                Log.d("Remove state", "Failed")
                            }
                    }
                }
            }
    }
    fun deleteAllChat(senderId: Long, receivedId: Long) {
        val collectionRef = fireStore.collection("Chat")
        collectionRef.whereIn("senderID", listOf(senderId, receivedId))
            .whereIn("receivedID", listOf(senderId, receivedId))
            .get().addOnCompleteListener {
                if (it.isSuccessful) {
                    for (document in it.result) {
                        if (document != null && document.exists()) {
                            document.reference.delete()
                                .addOnSuccessListener {
                                    Log.d("Remove all chat state", "Success")
                                }
                                .addOnFailureListener {
                                    Log.d("Remove all chat state", "Failed")
                                }
                        }
                    }
                }
            }
    }

    private fun getReadableDateTime(date: Date): String {
        return SimpleDateFormat("MMMM dd, yyyy - hh:mm a", Locale.getDefault()).format(date)
    }

    interface GetChatStatus {
        fun RecentMessage()
        fun newMessage()
        fun noMessage()
    }

    //Conservation
    //Conservation id, idUser1, idUser2, User1Name, User2Name, User1Image, User2Image, lastMessage, time
    fun addConversation(
        user1Id: Long,
        user2Id: Long,
        user1Name: String,
        user2Name: String,
        user1Image: String,
        user2Image: String,
        lastMessage: String,
        date: Date,
        getConversation: GetConversation, isImage: Long
    ) {
        val collectionRef = fireStore.collection("Conversation")
        val conversation: MutableMap<String, Any> = HashMap()
        conversation["idUser1"] = user1Id
        conversation["idUser2"] = user2Id
        conversation["User1Name"] = user1Name
        conversation["User2Name"] = user2Name
        conversation["User1Image"] = user1Image
        conversation["User2Image"] = user2Image
        conversation["lastMessage"] = lastMessage
        conversation["lastId"] = user1Id
        conversation["time"] = date
        conversation["isSeen"] = 0
        conversation["isImage"] = isImage
        collectionRef.add(conversation).addOnSuccessListener {
            getConversation.getId(it.id)
        }
    }

    fun updateConversation(conversationId: String, message: String, userId : Long, isSeen : Long, isImage: Long) {
        val collectionRef = fireStore.collection("Conversation")
        val documentRef = collectionRef.document(conversationId)
        documentRef.update(
            "lastMessage", message,
            "time", Date(),
            "lastId", userId,
            "isSeen", isSeen,
            "isImage", isImage
        )
            .addOnCompleteListener {
                Log.d("Info : ", "Update Success")
            }
    }
    fun updateSeenConversation(conversationId: String,isSeen : Long) {
        val collectionRef = fireStore.collection("Conversation")
        val documentRef = collectionRef.document(conversationId)
        documentRef.update(
            "isSeen", isSeen
        )
            .addOnCompleteListener {
                Log.d("Info Seen Message: ", "Update Success")
            }
    }
    //Color
    fun updateThemColorConservation(conversationId: String, color : String){
        val collectionRef = fireStore.collection("Conversation")
        val documentRef = collectionRef.document(conversationId)
        documentRef.update(
            "Color", color
        )
            .addOnCompleteListener {
                Log.d("Info Seen Message: ", "Update Success")
            }
    }
    fun updateNicknameConservation(conversationId: String, nickname : String, userId : Long){
        val collectionRef = fireStore.collection("Conversation")
        val documentRef = collectionRef.document(conversationId)
        documentRef.update("Nickname for $userId" , nickname)
            .addOnCompleteListener {
                Log.d("Update Nickname", "Success")
            }
    }

    fun getNickname(conversationId : String, userId: Long, getNickname: GetNickname){
        fireStore.collection("Conversation")
            .document(conversationId)
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val nickname = it.result.getString("Nickname for $userId")
                    if(nickname != null) {
                        getNickname.getNickname(nickname)
                    }
                    else{
                        Log.d("Get Nickname Status ", "False")
                        getNickname.noHaveNickname()
                    }
                }
            }
    }


    interface GetNickname{
        fun getNickname(nickname: String)
        fun noHaveNickname()
    }

    interface GetConversionName{
        fun getConversionName(conversation : ChatMessage)
    }


    interface GetConversation {
        fun getId(id: String)
        fun getColor(color : String)
        fun getLastTime(time: String)
        fun getIcon(icon: String)
        fun onFailure()
    }

    fun checkForConversation(user1Id: Long, user2Id: Long, getConversation: GetConversation) {
        val collectionRef = fireStore.collection("Conversation")
        collectionRef.whereIn("idUser1", listOf(user1Id, user2Id))
            .whereIn("idUser2", listOf(user1Id, user2Id))
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    val color = it.documents[0].getString("Color")
                    if (color != null) {
                        getConversation.getColor(color)
                    }
                    val icon = it.documents[0].getString("Icon")
                    if(icon != null){
                        getConversation.getIcon(icon)
                    }
                    getConversation.getId(it.documents[0].id)
                    val recentTime = it.documents[0].getDate("time").toString()
                    getConversation.getLastTime(recentTime)

                }
                else{
                    getConversation.onFailure()
                }
            }
            .addOnFailureListener {
                getConversation.onFailure()
            }
    }
    fun getNameConversation(
        userId: Long,
        getConversation: GetConversionName,
        conversationId: String
    ) {
        val eventListener: EventListener<DocumentSnapshot> = EventListener { snapshot, _ ->
            if (snapshot != null && snapshot.exists()) {
                val chatMessage = ChatMessage()
                val user1IdValue = snapshot.getLong("idUser1")
                val user2IdValue = snapshot.getLong("idUser2")
                val nickname1 = snapshot.getString("Nickname for $user1IdValue").toString()
                val nickname2 = snapshot.getString("Nickname for $user2IdValue").toString()
                val conversationName: String
                var conversationNickname: String
                if (userId == user1IdValue) {
                    conversationName = snapshot.getString("User2Name")!!
                    conversationNickname = nickname2
                } else {
                    conversationName = snapshot.getString("User1Name")!!
                    conversationNickname = nickname1
                }
                chatMessage.conversionName = conversationName
                chatMessage.conversionNickname = conversationNickname
                getConversation.getConversionName(chatMessage)
            }
        }

        fireStore.collection("Conversation")
            .document(conversationId)
            .addSnapshotListener(eventListener)
    }



    fun getConversation(senderId : Long, conversations : ArrayList<ChatMessage>, getChatStatus: GetChatStatus){
        val eventConversationListener: EventListener<QuerySnapshot> = EventListener { value, _ ->
            if (value != null) {
                for(documentChange in value.documentChanges){
                    if(documentChange.type == DocumentChange.Type.ADDED){
                        val user1IdValue = documentChange.document.getLong("idUser1")
                        val user2IdValue = documentChange.document.getLong("idUser2")
                        val nickname1 = documentChange.document.getString("Nickname for $user1IdValue").toString()
                        val nickname2 = documentChange.document.getString("Nickname for $user2IdValue").toString()
                        val conversationDocument = documentChange.document.id
                        val lastId = documentChange.document.getLong("lastId")
                        val conversationImage : String
                        val conversationName : String
                        val conversationId : String
                        var conversationNickname : String
                        if(senderId == user1IdValue){
                            conversationImage = documentChange.document.getString("User2Image")!!
                            conversationName  = documentChange.document.getString("User2Name")!!
                            conversationId = documentChange.document.getLong("idUser2").toString()
                            conversationNickname = nickname2
                        }else{
                            conversationImage = documentChange.document.getString("User1Image")!!
                            conversationName = documentChange.document.getString("User1Name")!!
                            conversationId = documentChange.document.getLong("idUser1").toString()
                            conversationNickname = nickname1
                        }
                        val message = documentChange.document.getString("lastMessage")
                        val dateObject = documentChange.document.getDate("time")
                        val isSeen = documentChange.document.getLong("isSeen")
                        val isImage = documentChange.document.getLong("isImage")
                        val chatMessage = ChatMessage(user1IdValue!!,user2IdValue!!, conversationImage, conversationName, conversationId, message!!, dateObject!!,lastId!!)
                        chatMessage.isSeen = isSeen
                        chatMessage.isImage = isImage
                        chatMessage.documentId = conversationDocument

                        chatMessage.conversionNickname = conversationNickname

                        conversations.add(chatMessage)
                    }
                    else if(documentChange.type == DocumentChange.Type.MODIFIED){
                        val userId1 = documentChange.document.getLong("idUser1")
                        val userId2 = documentChange.document.getLong("idUser2")
                        for(conversation in conversations){
                            if(conversation.getSenderID() == userId1 && conversation.getReceivedID() == userId2){
                                conversation.setMessage(documentChange.document.getString("lastMessage")!!)
                                conversation.dateObject = documentChange.document.getDate("time")!!
                                conversation.lastId = documentChange.document.getLong("lastId")
                                conversation.isSeen =  documentChange.document.getLong("isSeen")
                                conversation.isImage = documentChange.document.getLong("isImage")
                            }
                        }
                    }
                }
            }
            getChatStatus.newMessage()
        }
        fireStore.collection("Conversation").get().addOnCompleteListener {
            fireStore.collection("Conversation")
                .whereEqualTo("idUser1", senderId)
                .addSnapshotListener(eventConversationListener)
            fireStore.collection("Conversation")
                .whereEqualTo("idUser2", senderId)
                .addSnapshotListener(eventConversationListener)
        }
            .addOnFailureListener{
                Log.d("Error when query : " , "True")
            }
    }
    fun getLastId(conversationId : String, onReturnLastId: OnReturnLastId){
        fireStore.collection("Conversation")
            .document(conversationId)
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val lastId = it.result.getLong("lastId")
                    if(lastId != null) {
                        onReturnLastId.onReturnId(lastId)
                    }
                }
            }

    }
    interface OnReturnLastId{
        fun onReturnId(lastId : Long)
    }
    fun deleteConservation(conversationId: String){
        val collectionRef = fireStore.collection("Conversation")
        collectionRef.document(conversationId)
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val document = it.result
                    if(document != null && document.exists()){
                        document.reference.delete()
                            .addOnSuccessListener {
                                Log.d("Delete Conservation: ", "Success")
                            }
                            .addOnFailureListener {
                                Log.d("Delete Conservation : ", "Failed")
                            }
                    }
                }
            }

    }

    fun updateIconConversation(conversationId: String, icon: String) {
        val collectionRef = fireStore.collection("Conversation")
        val documentRef = collectionRef.document(conversationId)
        documentRef.update(
            "Icon", icon
        )
            .addOnCompleteListener {
                Log.d("Update Icon State ", "Update Success")
            }
    }

}