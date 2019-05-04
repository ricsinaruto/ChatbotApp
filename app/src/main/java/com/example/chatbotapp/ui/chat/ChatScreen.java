package com.example.chatbotapp.ui.chat;

import java.util.List;

public interface ChatScreen {
    void showMessages(List<String> messages);

    void updateMessages(String message);

    void updateChatbotName(String name);

    void showNetworkError(String errorMsg);
}
