package com.example.chatbotapp.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ChatViewModel extends AndroidViewModel {

    private ChatRepository chatRepository;
    private LiveData<List<Chat>> chatAll;

    public ChatViewModel(Application application) {
        super(application);
        chatRepository = new ChatRepository(application);
        chatAll = chatRepository.getAllChat();
    }

    LiveData<List<Chat>> getChatAll() {
        return chatAll;
    }

    void insert(Chat chat) { chatRepository.insert(chat);
    }
}
