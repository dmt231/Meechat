package com.example.chatapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003./0B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J.\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001b0\nJ.\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\"J\u0016\u0010\'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"J\u0016\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\"J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/example/chatapp/repository/UserRepository;", "", "()V", "fireStore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFireStore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setFireStore", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "userLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/example/chatapp/model/User;", "checkUserExist", "", "listener", "Lcom/example/chatapp/repository/UserRepository$OnExistListener;", "getAllUser", "getStatusChanged", "userId", "", "onSuccessListener", "Lcom/example/chatapp/repository/UserRepository$OnSuccessListener;", "getStatusUser", "getToken", "getUserAvailable", "listUserOnline", "Lkotlin/collections/ArrayList;", "getUserById", "getUser", "Lcom/example/chatapp/repository/UserRepository$GetUser;", "getUserLiveData", "register", "name", "", "password", "email", "img", "signOut", "updateImage", "image", "updateStatusAvailable", "status", "", "updateToken", "Token", "GetUser", "OnExistListener", "OnSuccessListener", "app_debug"})
public final class UserRepository {
    private androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.chatapp.model.User>> userLiveData;
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.firestore.FirebaseFirestore fireStore;
    
    public UserRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getFireStore() {
        return null;
    }
    
    public final void setFireStore(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.chatapp.model.User>> getUserLiveData() {
        return null;
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String img, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.OnSuccessListener onSuccessListener) {
    }
    
    public final void getUserById(long userId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.GetUser getUser) {
    }
    
    public final void getAllUser() {
    }
    
    public final void checkUserExist(@org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.OnExistListener listener) {
    }
    
    public final void updateToken(@org.jetbrains.annotations.NotNull()
    java.lang.String Token, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void updateImage(@org.jetbrains.annotations.NotNull()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void getToken(long userId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.OnSuccessListener onSuccessListener) {
    }
    
    public final void signOut(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void updateStatusAvailable(int status, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void getStatusChanged(long userId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.OnSuccessListener onSuccessListener) {
    }
    
    public final void getStatusUser(long userId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.OnSuccessListener onSuccessListener) {
    }
    
    public final void getUserAvailable(long userId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.model.User> listUserOnline, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.UserRepository.OnSuccessListener onSuccessListener) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/repository/UserRepository$OnExistListener;", "", "onExist", "", "exist", "", "app_debug"})
    public static abstract interface OnExistListener {
        
        public abstract void onExist(boolean exist);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/example/chatapp/repository/UserRepository$OnSuccessListener;", "", "onAvailable", "", "onReceivedToken", "token", "", "onRemove", "userId", "", "onSuccess", "onUnavailable", "app_debug"})
    public static abstract interface OnSuccessListener {
        
        public abstract void onSuccess();
        
        public abstract void onAvailable();
        
        public abstract void onUnavailable();
        
        public abstract void onRemove(long userId);
        
        public abstract void onReceivedToken(@org.jetbrains.annotations.NotNull()
        java.lang.String token);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/repository/UserRepository$GetUser;", "", "onSuccess", "", "user", "Lcom/example/chatapp/model/User;", "app_debug"})
    public static abstract interface GetUser {
        
        public abstract void onSuccess(@org.jetbrains.annotations.NotNull()
        com.example.chatapp.model.User user);
    }
}