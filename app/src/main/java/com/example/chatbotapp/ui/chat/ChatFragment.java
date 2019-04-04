package com.example.chatbotapp.ui.chat;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.chatbotapp.ChatbotApplication;

import javax.inject.Inject;

public class ChatFragment extends Fragment implements ChatScreen {
    @Inject
    ChatPresenter chatPresenter;

    public ChatFragment() {
        ChatbotApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        chatPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        chatPresenter.detachScreen();
        super.onDetach();
    }
}
