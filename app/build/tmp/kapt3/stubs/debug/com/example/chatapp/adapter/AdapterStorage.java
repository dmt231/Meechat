package com.example.chatapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/chatapp/adapter/AdapterStorage;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/chatapp/adapter/ViewHolderStorage;", "listImage", "Ljava/util/ArrayList;", "Lcom/example/chatapp/chat/ChatMessage;", "Lkotlin/collections/ArrayList;", "onclickListener", "Lcom/example/chatapp/adapter/AdapterStorage$OnclickListener;", "(Ljava/util/ArrayList;Lcom/example/chatapp/adapter/AdapterStorage$OnclickListener;)V", "getBitMapImage", "Landroid/graphics/Bitmap;", "image", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnclickListener", "app_debug"})
public final class AdapterStorage extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.chatapp.adapter.ViewHolderStorage> {
    private java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listImage;
    private com.example.chatapp.adapter.AdapterStorage.OnclickListener onclickListener;
    
    public AdapterStorage(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.chat.ChatMessage> listImage, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.AdapterStorage.OnclickListener onclickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.chatapp.adapter.ViewHolderStorage onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.ViewHolderStorage holder, int position) {
    }
    
    private final android.graphics.Bitmap getBitMapImage(java.lang.String image) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/adapter/AdapterStorage$OnclickListener;", "", "onClick", "", "image", "", "app_debug"})
    public static abstract interface OnclickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        java.lang.String image);
    }
}