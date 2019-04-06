package com.example.chatbotapp.ui.main;

import com.example.chatbotapp.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void login(String username, String password) {
        screen.login(username, password);
    }

    public void register(String username, String password) {
        screen.register(username, password);
    }
}
