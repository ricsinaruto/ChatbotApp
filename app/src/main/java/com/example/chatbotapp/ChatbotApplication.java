package com.example.chatbotapp;

import android.app.Application;

import com.example.chatbotapp.ui.UIModule;

public class ChatbotApplication extends Application {

    public static ChatbotApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerChatbotApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
