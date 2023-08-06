package com.example.chatapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000eH\u0017J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/chatapp/adapter/AdapterRecentChat;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/chatapp/adapter/RecentChatViewHolder;", "listChat", "Ljava/util/ArrayList;", "Lcom/example/chatapp/chat/ChatMessage;", "Lkotlin/collections/ArrayList;", "onClickListener", "Lcom/example/chatapp/adapter/AdapterRecentChat$OnClickListener;", "(Ljava/util/ArrayList;Lcom/example/chatapp/adapter/AdapterRecentChat$OnClickListener;)V", "listChatBackUp", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "getRecentImage", "Landroid/graphics/Bitmap;", "encode", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnClickListener", "app_debug"})
public final class AdapterRecentChat extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.chatapp.adapter.RecentChatViewHolder> {
    private java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChat;
    private java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChatBackUp;
    private final com.example.chatapp.adapter.AdapterRecentChat.OnClickListener onClickListener = null;
    
    public AdapterRecentChat(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listChat, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.AdapterRecentChat.OnClickListener onClickListener) {
        super();
    }
    
    private final android.graphics.Bitmap getRecentImage(java.lang.String encode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.chatapp.adapter.RecentChatViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.RecentChatViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Filter getFilter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/chatapp/adapter/AdapterRecentChat$OnClickListener;", "", "onClickListener", "", "senderId", "", "receivedId", "image", "", "name", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClickListener(long senderId, long receivedId, @org.jetbrains.annotations.NotNull()
        java.lang.String image, @org.jetbrains.annotations.NotNull()
        java.lang.String name);
    }
}