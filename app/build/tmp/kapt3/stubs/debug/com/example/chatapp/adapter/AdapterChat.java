package com.example.chatapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&\'B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/chatapp/adapter/AdapterChat;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "imageProfile", "Landroid/graphics/Bitmap;", "listChat", "Ljava/util/ArrayList;", "Lcom/example/chatapp/chat/ChatMessage;", "Lkotlin/collections/ArrayList;", "senderID", "", "onClickListener", "Lcom/example/chatapp/adapter/AdapterChat$OnClickListener;", "onLongClick", "Lcom/example/chatapp/adapter/AdapterChat$OnLongClickListener;", "(Landroid/graphics/Bitmap;Ljava/util/ArrayList;JLcom/example/chatapp/adapter/AdapterChat$OnClickListener;Lcom/example/chatapp/adapter/AdapterChat$OnLongClickListener;)V", "color", "", "isChangeColor", "", "typeReceived", "", "typeReceivedIcon", "typeReceivedImage", "typeSend", "typeSendIcon", "typeSendImage", "changeColor", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnClickListener", "OnLongClickListener", "app_debug"})
public final class AdapterChat extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private android.graphics.Bitmap imageProfile;
    private java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChat;
    private com.example.chatapp.adapter.AdapterChat.OnClickListener onClickListener;
    private com.example.chatapp.adapter.AdapterChat.OnLongClickListener onLongClick;
    private long senderID;
    private final int typeSend = 1;
    private final int typeReceived = 2;
    private final int typeSendImage = 3;
    private final int typeReceivedImage = 4;
    private final int typeSendIcon = 5;
    private final int typeReceivedIcon = 6;
    private java.lang.String color;
    private boolean isChangeColor = false;
    
    public AdapterChat(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap imageProfile, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChat, long senderID, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.AdapterChat.OnClickListener onClickListener, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.AdapterChat.OnLongClickListener onLongClick) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void changeColor(@org.jetbrains.annotations.NotNull()
    java.lang.String color) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/adapter/AdapterChat$OnClickListener;", "", "changeToImage", "", "image", "", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void changeToImage(@org.jetbrains.annotations.NotNull()
        java.lang.String image);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/adapter/AdapterChat$OnLongClickListener;", "", "onLongClick", "", "position", "", "app_debug"})
    public static abstract interface OnLongClickListener {
        
        public abstract void onLongClick(int position);
    }
}