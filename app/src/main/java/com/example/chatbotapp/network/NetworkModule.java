package com.example.chatbotapp.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public ChatApi provideChatApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.ENDPOINT_ADDRESS).build().create(ChatApi.class);
    }
}
