package com.example.chatbotapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StringResult {
    @SerializedName("message")
    @Expose
    private String message;

    public StringResult() {

    }

    public StringResult(String message) {
        this.message = message;
    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}
}
