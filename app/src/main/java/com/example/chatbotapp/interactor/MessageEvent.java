package com.example.chatbotapp.interactor;

public class MessageEvent {
    private String message;
    private String username;

    public MessageEvent() {

    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
