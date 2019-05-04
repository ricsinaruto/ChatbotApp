package com.example.chatbotapp.ui.chat;

import com.example.chatbotapp.di.Network;
import com.example.chatbotapp.interactor.ChatEvent;
import com.example.chatbotapp.interactor.ChatInteractor;
import com.example.chatbotapp.interactor.MessageEvent;
import com.example.chatbotapp.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    public void refreshChat(final String message, final String user) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                chatInteractor.sendMessage(message,user);
            }
        });
    }

    public void getChat(final String user) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                chatInteractor.getMessages(user);
            }
        });
    }

    public void refreshName(final String user, final String name) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                chatInteractor.updateChatbotName(user,name);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final MessageEvent event) {
        if (screen != null) {
            screen.updateMessages(event.getMessage());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final ChatEvent event) {
        if (screen != null) {
            screen.showMessages(event.getMessages());
        }
    }
}
