package com.example.chatbotapp.ui.main;

import android.os.Message;
import android.util.Log;

import com.example.chatbotapp.di.Network;
import com.example.chatbotapp.interactor.ChatEvent;
import com.example.chatbotapp.interactor.ChatInteractor;
import com.example.chatbotapp.interactor.MainInteractor;
import com.example.chatbotapp.interactor.MessageEvent;
import com.example.chatbotapp.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    Executor networkExecutor;
    MainInteractor mainInteractor;

    @Inject
    public MainPresenter(@Network Executor networkExecutor, MainInteractor mainInteractor) {
        this.networkExecutor = networkExecutor;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void login(final String username, final String password) {

        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mainInteractor.login(username, password);
            }
        });
    }

    public void register(final String username, final String password) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mainInteractor.register(username, password);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final MessageEvent event) {
        if (screen != null && event.getMessage().equals("success")) {
            screen.getMessages(event.getUsername());
        }
    }
}
