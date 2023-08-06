package com.example.chatapp.model

class Account {
    private var imageAccount : Int
    private var detail : String
    constructor(image : Int , detail : String){
        this.imageAccount = image
        this.detail = detail

    }
    fun getImage() : Int{
        return imageAccount
    }
    fun getDetail() : String{
        return detail
    }

}