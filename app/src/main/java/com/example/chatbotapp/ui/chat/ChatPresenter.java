package com.example.chatbotapp.ui.chat;

import com.example.chatbotapp.di.Network;
import com.example.chatbotapp.interactor.ChatInteractor;
import com.example.chatbotapp.ui.Presenter;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class ChatPresenter extends Presenter<ChatScreen> {
    Executor networkExecutor;
    ChatInteractor chatInteractor;

    @Inject
    public ChatPresenter(@Network Executor networkExecutor, ChatInteractor chatInteractor) {
        this.networkExecutor = networkExecutor;
        this.chatInteractor = chatInteractor;
    }

    @Override
    public void attachScreen(ChatScreen screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }
}