package com.example.chatbotapp;

import com.example.chatbotapp.mock.MockNetworkModule;
import com.example.chatbotapp.test.ChatTest;
import com.example.chatbotapp.test.MainTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends ChatbotApplicationComponent {
    void inject(MainTest mainTest);

    void inject(ChatTest chatTest);
}
