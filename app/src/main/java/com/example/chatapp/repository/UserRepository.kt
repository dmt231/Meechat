package com.example.chatapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.chatapp.model.User
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore


class UserRepository {
    private var userLiveData = MutableLiveData<ArrayList<User>>()
    var fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
    fun getUserLiveData(): MutableLiveData<ArrayList<User>> {
        return userLiveData
    }


    //Function register User
    fun register(
        name: String,
        password: String,
        email: String,
        img: String,
        onSuccessListener: OnSuccessListener
    ) {
        val collectionRef = fireStore.collection("User")
        val userMap: MutableMap<String, Any> = HashMap()
        userMap["Name"] = name
        userMap["Password"] = password
        userMap["Email"] = email
        userMap["Image"] = img
        userMap["Token"] = ""
        collectionRef.get().addOnSuccessListener { queryDocumentSnapshots ->
            var newUserId: Long = 1
            if (!queryDocumentSnapshots.isEmpty) {
                // Nếu có tài liệu, tìm giá trị UserId lớn nhất
                for (documentSnapshot in queryDocumentSnapshots) {
                    val userId = documentSnapshot.getLong("userId") ?: continue
                    if (userId > newUserId) {
                        newUserId = userId
                    }
                }
                // Tăng giá trị UserId lên 1 để tạo giá trị mới cho trường UserId
                newUserId++
            }
            userMap["userId"] = newUserId
            collectionRef.document(email).set(userMap).addOnCompleteListener {
                onSuccessListener.onSuccess()
            }
        }
    }
    fun getUserById(userId: Long, getUser: GetUser) {
        val collectionRef = fireStore.collection("User")
        collectionRef.orderBy("userId")
            .whereEqualTo("userId", userId)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful && !it.result.isEmpty) {
                    val name = it.result.documents[0].getString("Name")
                    val email = it.result.documents[0].getString("Email")
                    val image = it.result.documents[0].getString("Image")
                    val user = User(userId, name!!, email!!, image!!)
                    getUser.onSuccess(user)
                } else {
                    Log.d("Error : ", "Not found any user")
                }
            }
    }


    fun getAllUser() {
        val collectionRef = fireStore.collection("User")
        collectionRef.orderBy("userId")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful && !it.result.isEmpty) {
                    val listUser = ArrayList<User>()
                    for (document in it.result) {
                        val name = document.getString("Name")
                        val email = document.getString("Email")
                        val password = document.getString("Password")
                        val image = document.getString("Image")
                        val id = document.getLong("userId")
                        var token = ""
                        if (document.getString("Token") != null) {
                            token = document.getString("Token")!!
                        }
                        val user = User(id!!, name!!, password!!, email!!, image!!, token)
                        listUser.add(user)
                    }
                    userLiveData.value = listUser
                } else {
                    Log.d("Error : ", "Not found any user")
                }
            }
    }

    interface OnExistListener {
        fun onExist(exist: Boolean)
    }

    interface OnSuccessListener {
        fun onSuccess()
        fun onAvailable()
        fun onUnavailable()
        fun onRemove(userId: Long)
        fun onReceivedToken(token : String)
    }

    fun checkUserExist(listener: OnExistListener) {
        val collectionRef = fireStore.collection("User")
        collectionRef.get().addOnCompleteListener {
            if (it.isSuccessful && !it.result.isEmpty) {
                listener.onExist(true)
            } else {
                listener.onExist(false)
            }
        }
    }

    fun updateToken(Token: String, email: String) {
        val documentRef = fireStore.collection("User")
            .document(email)
        documentRef.update("Token", Token)
            .addOnCompleteListener {
                Log.d("Token Status : ", " Success")
            }
    }
    fun updateImage(image : String, email: String){
        val documentRef = fireStore.collection("User")
            .document(email)
        documentRef.update("Image", image)
            .addOnCompleteListener {
                Log.d("Update Image ", "Success")
            }
    }
    fun getToken(userId: Long, onSuccessListener: OnSuccessListener){
       fireStore.collection("User")
            .whereEqualTo("userId", userId)
            .get().addOnCompleteListener {
                if(it.isSuccessful){
                    val token = it.result.documents[0].getString("Token")
                    if(token != null){
                        Log.d("Token for $userId ", token)
                        onSuccessListener.onReceivedToken(token)
                    }
                }
            }
    }

    fun signOut(email: String) {
        val documentRef = fireStore.collection("User").document(email)
        documentRef.update("Token", FieldValue.delete())
            .addOnSuccessListener {
                Log.d("Token Status : ", "Success")
            }
    }

    fun updateStatusAvailable(status: Int, email: String) {
        fireStore.collection("User").document(email).update("Available", status)
            .addOnSuccessListener {
                Log.d("Available Status : ", status.toString())
            }
    }

    fun getStatusChanged(userId: Long, onSuccessListener: OnSuccessListener) {
        fireStore.collection("User")
            .whereEqualTo("userId", userId)
            .addSnapshotListener { value, _ ->
                if (value != null) {
                    for (documentChange in value.documentChanges) {
                        if (documentChange.type == DocumentChange.Type.MODIFIED) {
                            val status = documentChange.document.getLong("Available")
                            if (status!!.toInt() == 1) {
                                onSuccessListener.onAvailable()
                            } else {
                                onSuccessListener.onUnavailable()
                            }
                        }
                    }
                }
            }
    }
    fun getStatusUser(userId: Long, onSuccessListener: OnSuccessListener){
        fireStore.collection("User")
            .whereEqualTo("userId", userId)
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val status = it.result.documents[0].getLong("Available")
                    if(status != null) {
                        if (status.toInt() == 1) {
                            onSuccessListener.onAvailable()
                        } else {
                            onSuccessListener.onUnavailable()
                        }
                    }
                }
            }
    }
    fun getUserAvailable(userId: Long,listUserOnline : ArrayList<User>, onSuccessListener: OnSuccessListener){
        fireStore.collection("User")
            .whereEqualTo("Available", 1)
            .addSnapshotListener{value, _ ->
                if(value != null){
                    for(documentChange in value.documentChanges){
                        if(documentChange.type == DocumentChange.Type.ADDED){
                            val userIdValue = documentChange.document.getLong("userId")!!
                            val image = documentChange.document.getString("Image")!!
                            val name = documentChange.document.getString("Name")!!
                            if(userIdValue != userId) {
                                listUserOnline.add(User(userIdValue, name, image))
                            }
                            onSuccessListener.onSuccess()
                        }
                        else if(documentChange.type == DocumentChange.Type.REMOVED){
                            val userId = documentChange.document.getLong("userId")!!
                            Log.d("User remove : ", userId.toString())
                            onSuccessListener.onRemove(userId)
                        }
                    }
                }
            }
    }
    interface GetUser{
        fun onSuccess(user : User)
    }
}