package com.example.chatbotapp.interactor;

import com.example.chatbotapp.ChatbotApplication;

import javax.inject.Inject;

public class MainInteractor {
    @Inject
    public MainInteractor() {
        ChatbotApplication.injector.inject(this);
    }

    public void login(String username, String password) {

    }

    public void register(String username, String password) {

    }
}
