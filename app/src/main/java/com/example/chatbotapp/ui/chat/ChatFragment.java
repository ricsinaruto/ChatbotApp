package com.example.chatbotapp.ui.chat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.chatbotapp.ChatbotApplication;
import com.example.chatbotapp.model.Chat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChatFragment extends Fragment implements ChatScreen {
    @Inject
    ChatPresenter chatPresenter;
    private Chat chat;
    private ChatAdapter chatAdapter;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<String> messages = chat.getMessages();
        chatPresenter.refreshChat(messages.get(messages.size() - 1));
    }

    public void showMessages(List<String> messages) {

    }

    @Override
    public void showNetworkError(String errorMsg) {

    }
}
