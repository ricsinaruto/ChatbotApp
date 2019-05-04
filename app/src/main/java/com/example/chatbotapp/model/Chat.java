package com.example.chatbotapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

@Entity(tableName="chat_table")
public class Chat {
    @PrimaryKey
    @ColumnInfo(name="username")
    @SerializedName("username")
    @Expose
    @NonNull
    private String username;

    @ColumnInfo(name="chatbot name")
    @SerializedName("chatbotname")
    @Expose
    private String chatbotname;


    @SerializedName("messages")
    @Expose
    @Ignore
    private List<String> messages;

    @ColumnInfo(name="messages")
    private String concatMessages;

    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getChatbotname() {
        return chatbotname;
    }

    public void setChatbotname(String chatbotname) {
        this.chatbotname = chatbotname;
    }



    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;

        String allM=new String();
        for(String m: messages) {
            allM+="|"+m;
        }
        this.concatMessages = allM;
    }

    public String getConcatMessages() {
        return concatMessages;
    }

    public void setConcatMessages(String concatMessages) {
        this.concatMessages = concatMessages;
    }
}
