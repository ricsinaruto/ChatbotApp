package com.example.chatbotapp.interactor;

import com.example.chatbotapp.ChatbotApplication;

import javax.inject.Inject;


public class ChatInteractor {
    @Inject
    public ChatInteractor() {
        ChatbotApplication.injector.inject(this);
    }

}
