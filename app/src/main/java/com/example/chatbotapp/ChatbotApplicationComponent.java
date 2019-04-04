package com.example.chatbotapp;

import javax.inject.Singleton;

import dagger.Component;
import com.example.chatbotapp.interactor.ChatInteractor;
import com.example.chatbotapp.network.NetworkModule;
import com.example.chatbotapp.ui.UIModule;
import com.example.chatbotapp.ui.chat.ChatFragment;
import com.example.chatbotapp.ui.chat.ChatPresenter;
import com.example.chatbotapp.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface ChatbotApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(ChatFragment chatFragment);

    void inject(ChatInteractor chatInteractor);

    void inject(ChatPresenter chatPresenter);
}
