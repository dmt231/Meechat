package com.example.chatapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0005<=>?@B\u0005\u00a2\u0006\u0002\u0010\u0002JV\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000bJ6\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010\"\u001a\u00020#J.\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010%\u001a\u00020#J6\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010%\u001a\u00020#J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u001e\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u000bJ\u001e\u0010.\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J.\u00101\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\bJ.\u00103\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u00105\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bJ\u001e\u00107\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\bJ\u0016\u00109\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\bJ\u0016\u0010:\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/example/chatapp/repository/ChatRepository;", "", "()V", "fireStore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "addConversation", "", "user1Id", "", "user2Id", "user1Name", "", "user2Name", "user1Image", "user2Image", "lastMessage", "date", "Ljava/util/Date;", "getConversation", "Lcom/example/chatapp/repository/ChatRepository$GetConversation;", "isImage", "checkForConversation", "deleteAllChat", "senderId", "receivedId", "deleteChat", "chatId", "deleteConservation", "conversationId", "getChat", "listChat", "Ljava/util/ArrayList;", "Lcom/example/chatapp/chat/ChatMessage;", "Lkotlin/collections/ArrayList;", "status", "Lcom/example/chatapp/repository/ChatRepository$GetChatStatus;", "conversations", "getChatStatus", "getImageStorage", "listImage", "getLastId", "onReturnLastId", "Lcom/example/chatapp/repository/ChatRepository$OnReturnLastId;", "getNameConversation", "userId", "Lcom/example/chatapp/repository/ChatRepository$GetConversionName;", "getNickname", "Lcom/example/chatapp/repository/ChatRepository$GetNickname;", "getReadableDateTime", "sendMessage", "message", "updateConversation", "isSeen", "updateIconConversation", "icon", "updateNicknameConservation", "nickname", "updateSeenConversation", "updateThemColorConservation", "color", "GetChatStatus", "GetConversation", "GetConversionName", "GetNickname", "OnReturnLastId", "app_debug"})
public final class ChatRepository {
    private com.google.firebase.firestore.FirebaseFirestore fireStore;
    
    public ChatRepository() {
        super();
    }
    
    public final void sendMessage(long senderId, long receivedId, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.Date date, long isImage) {
    }
    
    public final void getChat(long senderId, long receivedId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChat, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetChatStatus status) {
    }
    
    public final void getImageStorage(long senderId, long receivedId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listImage, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetChatStatus getChatStatus) {
    }
    
    public final void deleteChat(@org.jetbrains.annotations.NotNull()
    java.lang.String chatId) {
    }
    
    public final void deleteAllChat(long senderId, long receivedId) {
    }
    
    private final java.lang.String getReadableDateTime(java.util.Date date) {
        return null;
    }
    
    public final void addConversation(long user1Id, long user2Id, @org.jetbrains.annotations.NotNull()
    java.lang.String user1Name, @org.jetbrains.annotations.NotNull()
    java.lang.String user2Name, @org.jetbrains.annotations.NotNull()
    java.lang.String user1Image, @org.jetbrains.annotations.NotNull()
    java.lang.String user2Image, @org.jetbrains.annotations.NotNull()
    java.lang.String lastMessage, @org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetConversation getConversation, long isImage) {
    }
    
    public final void updateConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String message, long userId, long isSeen, long isImage) {
    }
    
    public final void updateSeenConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, long isSeen) {
    }
    
    public final void updateThemColorConservation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String color) {
    }
    
    public final void updateNicknameConservation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname, long userId) {
    }
    
    public final void getNickname(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, long userId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetNickname getNickname) {
    }
    
    public final void checkForConversation(long user1Id, long user2Id, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetConversation getConversation) {
    }
    
    public final void getNameConversation(long userId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetConversionName getConversation, @org.jetbrains.annotations.NotNull()
    java.lang.String conversationId) {
    }
    
    public final void getConversation(long senderId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.chat.ChatMessage> conversations, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.GetChatStatus getChatStatus) {
    }
    
    public final void getLastId(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.repository.ChatRepository.OnReturnLastId onReturnLastId) {
    }
    
    public final void deleteConservation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId) {
    }
    
    public final void updateIconConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String icon) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/repository/ChatRepository$GetChatStatus;", "", "RecentMessage", "", "newMessage", "noMessage", "app_debug"})
    public static abstract interface GetChatStatus {
        
        public abstract void RecentMessage();
        
        public abstract void newMessage();
        
        public abstract void noMessage();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/chatapp/repository/ChatRepository$GetNickname;", "", "getNickname", "", "nickname", "", "noHaveNickname", "app_debug"})
    public static abstract interface GetNickname {
        
        public abstract void getNickname(@org.jetbrains.annotations.NotNull()
        java.lang.String nickname);
        
        public abstract void noHaveNickname();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/repository/ChatRepository$GetConversionName;", "", "getConversionName", "", "conversation", "Lcom/example/chatapp/chat/ChatMessage;", "app_debug"})
    public static abstract interface GetConversionName {
        
        public abstract void getConversionName(@org.jetbrains.annotations.NotNull()
        com.example.chatapp.chat.ChatMessage conversation);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/example/chatapp/repository/ChatRepository$GetConversation;", "", "getColor", "", "color", "", "getIcon", "icon", "getId", "id", "getLastTime", "time", "onFailure", "app_debug"})
    public static abstract interface GetConversation {
        
        public abstract void getId(@org.jetbrains.annotations.NotNull()
        java.lang.String id);
        
        public abstract void getColor(@org.jetbrains.annotations.NotNull()
        java.lang.String color);
        
        public abstract void getLastTime(@org.jetbrains.annotations.NotNull()
        java.lang.String time);
        
        public abstract void getIcon(@org.jetbrains.annotations.NotNull()
        java.lang.String icon);
        
        public abstract void onFailure();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/repository/ChatRepository$OnReturnLastId;", "", "onReturnId", "", "lastId", "", "app_debug"})
    public static abstract interface OnReturnLastId {
        
        public abstract void onReturnId(long lastId);
    }
}