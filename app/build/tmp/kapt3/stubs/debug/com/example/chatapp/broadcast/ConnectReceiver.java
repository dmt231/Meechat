package com.example.chatapp.broadcast;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/example/chatapp/broadcast/ConnectReceiver;", "Landroid/content/BroadcastReceiver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "state", "", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "customToastOffline", "", "message", "customToastOnline", "onReceive", "context", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "app_debug"})
public final class ConnectReceiver extends android.content.BroadcastReceiver {
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String state;
    
    public ConnectReceiver(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent p1) {
    }
    
    private final void customToastOnline(java.lang.String message, android.app.Activity activity) {
    }
    
    private final void customToastOffline(java.lang.String message, android.app.Activity activity) {
    }
}