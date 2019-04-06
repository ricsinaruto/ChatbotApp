package com.example.chatbotapp.ui.chat;

import java.util.List;

public interface ChatScreen {
    void showMessages(List<String> messages);

    void showNetworkError(String errorMsg);
}
