package com.example.chatapp.setting;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\"\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/chatapp/setting/Settings;", "Landroidx/fragment/app/Fragment;", "mainFragment", "Lcom/example/chatapp/main/MainFragment;", "(Lcom/example/chatapp/main/MainFragment;)V", "adapter", "Lcom/example/chatapp/adapter/AdapterSetting;", "binding", "Lcom/example/chatapp/databinding/LayoutSettingBinding;", "listDetail", "Ljava/util/ArrayList;", "Lcom/example/chatapp/model/Account;", "Lkotlin/collections/ArrayList;", "preferences", "Lcom/example/chatapp/storage/Preferences;", "repository", "Lcom/example/chatapp/repository/UserRepository;", "encodeImage", "", "bitmap", "Landroid/graphics/Bitmap;", "getImageProfileBitmap", "loadImageUser", "", "logTest", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChangeToSeeImage", "imageBitmap", "isSelect", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openDialogImageProfile", "openMedia", "setUpRecycler", "app_debug"})
public final class Settings extends androidx.fragment.app.Fragment {
    private com.example.chatapp.databinding.LayoutSettingBinding binding;
    private com.example.chatapp.adapter.AdapterSetting adapter;
    private java.util.ArrayList<com.example.chatapp.model.Account> listDetail;
    private com.example.chatapp.main.MainFragment mainFragment;
    private com.example.chatapp.repository.UserRepository repository;
    private com.example.chatapp.storage.Preferences preferences;
    
    public Settings(@org.jetbrains.annotations.NotNull()
    com.example.chatapp.main.MainFragment mainFragment) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void logTest() {
    }
    
    private final void loadImageUser() {
    }
    
    private final android.graphics.Bitmap getImageProfileBitmap() {
        return null;
    }
    
    private final void setUpRecycler() {
    }
    
    private final void openDialogImageProfile() {
    }
    
    private final void onChangeToSeeImage(android.graphics.Bitmap imageBitmap, boolean isSelect) {
    }
    
    private final void openMedia() {
    }
    
    private final java.lang.String encodeImage(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}