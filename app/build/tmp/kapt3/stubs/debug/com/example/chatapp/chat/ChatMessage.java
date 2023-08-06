package com.example.chatapp.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nBG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0011B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0012J\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0003J\u0006\u00104\u001a\u00020\u0003J\u000e\u00105\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b\'\u0010\u0017R\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010,R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010,\u00a8\u00067"}, d2 = {"Lcom/example/chatapp/chat/ChatMessage;", "", "senderID", "", "receivedID", "message", "", "dateTime", "date", "Ljava/util/Date;", "(JJLjava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "conversionImage", "conversionName", "conversionId", "lastMessage", "dateObject", "lastId", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;J)V", "()V", "chatId", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "getConversionId", "setConversionId", "getConversionImage", "setConversionImage", "getConversionName", "setConversionName", "conversionNickname", "getConversionNickname", "setConversionNickname", "getDateObject", "()Ljava/util/Date;", "setDateObject", "(Ljava/util/Date;)V", "documentId", "getDocumentId", "setDocumentId", "isImage", "()Ljava/lang/Long;", "setImage", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isSeen", "setSeen", "getLastId", "setLastId", "getDatetime", "getMessage", "getReceivedID", "getSenderID", "setMessage", "", "app_debug"})
public final class ChatMessage {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String documentId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String chatId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String conversionId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String conversionImage;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String conversionName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String conversionNickname;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long lastId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long isSeen;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long isImage;
    private java.lang.Long senderID;
    private java.lang.Long receivedID;
    private java.lang.String message;
    private java.lang.String dateTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date dateObject;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDocumentId() {
        return null;
    }
    
    public final void setDocumentId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChatId() {
        return null;
    }
    
    public final void setChatId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getConversionId() {
        return null;
    }
    
    public final void setConversionId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getConversionImage() {
        return null;
    }
    
    public final void setConversionImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getConversionName() {
        return null;
    }
    
    public final void setConversionName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getConversionNickname() {
        return null;
    }
    
    public final void setConversionNickname(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getLastId() {
        return null;
    }
    
    public final void setLastId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long isSeen() {
        return null;
    }
    
    public final void setSeen(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long isImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getDateObject() {
        return null;
    }
    
    public final void setDateObject(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    public ChatMessage(long senderID, long receivedID, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String dateTime, @org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        super();
    }
    
    public ChatMessage(long senderID, long receivedID, @org.jetbrains.annotations.NotNull()
    java.lang.String conversionImage, @org.jetbrains.annotations.NotNull()
    java.lang.String conversionName, @org.jetbrains.annotations.NotNull()
    java.lang.String conversionId, @org.jetbrains.annotations.NotNull()
    java.lang.String lastMessage, @org.jetbrains.annotations.NotNull()
    java.util.Date dateObject, long lastId) {
        super();
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final long getSenderID() {
        return 0L;
    }
    
    public final long getReceivedID() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDatetime() {
        return null;
    }
    
    public ChatMessage() {
        super();
    }
}