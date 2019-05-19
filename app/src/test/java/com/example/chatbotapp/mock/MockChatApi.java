package com.example.chatbotapp.mock;

import com.example.chatbotapp.model.ChatResult;
import com.example.chatbotapp.model.StringResult;
import com.example.chatbotapp.network.ChatApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.Query;

public class MockChatApi implements ChatApi {
    @Override
    public Call<ChatResult> getChat(@Query("username") String username) {
        final ChatResult chatResult = new ChatResult();
        List<String> utts = new ArrayList<String>();
        utts.add("Hi");
        utts.add("Hello");
        chatResult.setUtterances(utts);

        Call<ChatResult> call = new Call<ChatResult>() {
            @Override
            public Response<ChatResult> execute() throws IOException {
                return Response.success(chatResult);
            }

            @Override
            public void enqueue(Callback<ChatResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<ChatResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<StringResult> sendMessage(@Field("body") StringResult body, @Query("username") String username) {
        final StringResult stringResult = new StringResult();
        stringResult.setMessage("How are you?");

        Call<StringResult> call = new Call<StringResult>() {
            @Override
            public Response<StringResult> execute() throws IOException {
                return Response.success(stringResult);
            }

            @Override
            public void enqueue(Callback<StringResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<StringResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<StringResult> changeChatbotName(@Query("username") String username, @Query("chatbotName") String chatbotname) {
        final StringResult stringResult = new StringResult();
        stringResult.setMessage("success");

        Call<StringResult> call = new Call<StringResult>() {
            @Override
            public Response<StringResult> execute() throws IOException {
                return Response.success(stringResult);
            }

            @Override
            public void enqueue(Callback<StringResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<StringResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<StringResult> registerUser(@Query("username") String username, @Query("password") String password) {
        final StringResult stringResult = new StringResult();
        stringResult.setMessage("success");

        Call<StringResult> call = new Call<StringResult>() {
            @Override
            public Response<StringResult> execute() throws IOException {
                return Response.success(stringResult);
            }

            @Override
            public void enqueue(Callback<StringResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<StringResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<StringResult> loginUser(@Query("username") String username, @Query("password") String password) {
        final StringResult stringResult = new StringResult();
        stringResult.setMessage("success");

        Call<StringResult> call = new Call<StringResult>() {
            @Override
            public Response<StringResult> execute() throws IOException {
                return Response.success(stringResult);
            }

            @Override
            public void enqueue(Callback<StringResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<StringResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
