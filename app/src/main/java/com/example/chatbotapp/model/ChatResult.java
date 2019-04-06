package com.example.chatbotapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatResult {

    @SerializedName("artists")
    @Expose
    private Chat chat;

    public Chat getChat() {return chat;}

    public void setChat(Chat chat) {this.chat = chat;}
}
