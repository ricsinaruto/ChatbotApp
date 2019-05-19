package com.example.chatbotapp.network;

import com.example.chatbotapp.model.ChatResult;
import com.example.chatbotapp.model.StringResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ChatApi {
    @GET("chat")
    Call<ChatResult> getChat(@Query("username") String username);

    @POST("chat/message")
    Call<StringResult> sendMessage(@Body StringResult message,
                                   @Query("username") String username);

    @GET("user/chatbotName")
    Call<StringResult> changeChatbotName(@Query("username") String username,
                                         @Query("chatbotName") String chatbotname);

    @GET("user/register")
    Call<StringResult> registerUser(@Query("username") String username,
                                    @Query("password") String password);

    @GET("user/login")
    Call<StringResult> loginUser(@Query("username") String username,
                                 @Query("password") String password);
}
