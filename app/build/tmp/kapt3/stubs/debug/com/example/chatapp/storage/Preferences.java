package com.example.chatapp.storage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/chatapp/storage/Preferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "myPreferences", "", "deleteUser", "", "getEmailUser", "getImageUser", "getNameUser", "getStatusValues", "getTokenUser", "getUserValues", "", "putEmailUser", "email", "putImageUser", "image", "putNameUser", "name", "putStatusValues", "status", "putTokenUser", "token", "putUser", "userID", "app_debug"})
public final class Preferences {
    private final java.lang.String myPreferences = "MyPreferences";
    private final android.content.Context context = null;
    
    public Preferences(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void putStatusValues(@org.jetbrains.annotations.NotNull()
    java.lang.String status) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatusValues() {
        return null;
    }
    
    public final void putUser(long userID) {
    }
    
    public final long getUserValues() {
        return 0L;
    }
    
    public final void putImageUser(@org.jetbrains.annotations.NotNull()
    java.lang.String image) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUser() {
        return null;
    }
    
    public final void putEmailUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmailUser() {
        return null;
    }
    
    public final void putNameUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNameUser() {
        return null;
    }
    
    public final void deleteUser() {
    }
    
    public final void putTokenUser(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTokenUser() {
        return null;
    }
}