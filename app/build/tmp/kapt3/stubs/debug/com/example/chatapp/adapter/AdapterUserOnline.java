package com.example.chatapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/chatapp/adapter/AdapterUserOnline;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/chatapp/adapter/UserOnlineViewHolder;", "listUser", "Ljava/util/ArrayList;", "Lcom/example/chatapp/model/User;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/example/chatapp/adapter/AdapterUserOnline$OnClickListener;", "(Ljava/util/ArrayList;Lcom/example/chatapp/adapter/AdapterUserOnline$OnClickListener;)V", "onClick", "getItemCount", "", "getRecentImage", "Landroid/graphics/Bitmap;", "encode", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnClickListener", "app_debug"})
public final class AdapterUserOnline extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.chatapp.adapter.UserOnlineViewHolder> {
    private java.util.ArrayList<com.example.chatapp.model.User> listUser;
    private com.example.chatapp.adapter.AdapterUserOnline.OnClickListener onClick;
    
    public AdapterUserOnline(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chatapp.model.User> listUser, @org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.AdapterUserOnline.OnClickListener listener) {
        super();
    }
    
    private final android.graphics.Bitmap getRecentImage(java.lang.String encode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.chatapp.adapter.UserOnlineViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.chatapp.adapter.UserOnlineViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/chatapp/adapter/AdapterUserOnline$OnClickListener;", "", "onClick", "", "user", "Lcom/example/chatapp/model/User;", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.example.chatapp.model.User user);
    }
}