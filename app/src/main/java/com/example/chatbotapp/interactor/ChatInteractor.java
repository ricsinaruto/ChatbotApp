package com.example.chatbotapp.interactor;

import com.example.chatbotapp.ChatbotApplication;
import com.example.chatbotapp.model.ChatResult;
import com.example.chatbotapp.model.StringResult;
import com.example.chatbotapp.network.ChatApi;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;


public class ChatInteractor {
    ChatApi chatApi;

    @Inject
    public ChatInteractor(ChatApi chatApi) {
        this.chatApi = chatApi;
        ChatbotApplication.injector.inject(this);
    }

    public void sendMessage(String message, String username) {
        MessageEvent event = new MessageEvent();

        Call<StringResult> chatQueryCall = chatApi.sendMessage("{\"message\":"+message+"}", username);
        try {
            Response<StringResult> response = chatQueryCall.execute();
            event.setMessage(response.body().getMessage());
            EventBus.getDefault().post(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMessages(String username) {
        ChatEvent event = new ChatEvent();

        Call<ChatResult> chatQueryCall = chatApi.getChat(username);
        try {
            Response<ChatResult> response = chatQueryCall.execute();
            event.setMessages(response.body().getUtterances());
            EventBus.getDefault().post(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateChatbotName(String username, String name) {
        MessageEvent event = new MessageEvent();
        Call<StringResult> chatQueryCall = chatApi.changeChatbotName(username, name);
        try {
            Response<StringResult> response = chatQueryCall.execute();
            event.setMessage(response.body().getMessage());
            EventBus.getDefault().post(event);
        } catch(Exception e) {

        }
    }
}
