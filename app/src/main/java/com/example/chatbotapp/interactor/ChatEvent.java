package com.example.chatbotapp.interactor;

import java.util.List;

public class ChatEvent {
    private List<String> messages;

    public ChatEvent() {

    }

    public ChatEvent(List<String> messages) {
        this.messages = messages;
    }

    public void setMessages(List<String> messages) {this.messages = messages;}

    public List<String> getMessages() {return messages;}
}
