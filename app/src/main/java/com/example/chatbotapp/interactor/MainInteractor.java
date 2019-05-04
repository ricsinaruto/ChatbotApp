package com.example.chatbotapp.interactor;

import android.util.Log;

import com.example.chatbotapp.ChatbotApplication;
import com.example.chatbotapp.model.ChatResult;
import com.example.chatbotapp.model.StringResult;
import com.example.chatbotapp.network.ChatApi;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class MainInteractor {

    ChatApi chatApi;

    @Inject
    public MainInteractor(ChatApi chatApi) {
        this.chatApi = chatApi;
        ChatbotApplication.injector.inject(this);
    }

    public void login(String username, String password) {
        Call<StringResult> query = chatApi.loginUser(username,password);
        MessageEvent event = new MessageEvent();

        try {
            Response<StringResult> response = query.execute();
            event.setMessage(response.body().getMessage());
            event.setUsername(username);
            EventBus.getDefault().post(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void register(String username, String password) {
        Call<StringResult> query = chatApi.registerUser(username,password);
        MessageEvent event = new MessageEvent();

        try {
            Response<StringResult> response = query.execute();
            event.setMessage(response.body().getMessage());
            event.setUsername(username);
            EventBus.getDefault().post(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
