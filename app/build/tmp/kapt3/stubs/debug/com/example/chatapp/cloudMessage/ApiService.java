package com.example.chatapp.cloudMessage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00072\b\b\u0001\u0010\b\u001a\u00020\u0004H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/chatapp/cloudMessage/ApiService;", "", "sendMessage", "Lretrofit2/Call;", "", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "messageBody", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "send")
    public abstract retrofit2.Call<java.lang.String> sendMessage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.HeaderMap()
    java.util.HashMap<java.lang.String, java.lang.String> headers, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.lang.String messageBody);
}