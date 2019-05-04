package com.example.chatbotapp.ui.chat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.chatbotapp.ChatbotApplication;
import com.example.chatbotapp.R;
import com.example.chatbotapp.model.Chat;
import com.example.chatbotapp.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChatFragment extends Fragment implements ChatScreen {
    @Inject
    ChatPresenter chatPresenter;
    private EditText editMessage;
    private RecyclerView chatView;
    private Chat chat = new Chat();
    private ChatAdapter chatAdapter;
    private Button sendButton;
    private List<String> utterances;

    public ChatFragment() {
        ChatbotApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        chat.setUsername(getActivity().getIntent().getStringExtra(MainActivity.KEY));
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
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        editMessage = view.findViewById(R.id.editMessage);
        sendButton = view.findViewById(R.id.sendText);
        chatView = view.findViewById(R.id.RecylerView);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        chatView.setLayoutManager(llm);

        utterances = new ArrayList<String>();
        chat.setMessages(utterances);
        chatAdapter = new ChatAdapter(getContext(), utterances);
        chatView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatPresenter.refreshChat(editMessage.getText().toString(), chat.getUsername());
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        chatPresenter.getChat(chat.getUsername());
    }

    @Override
    public void showMessages(List<String> messages) {
        utterances.addAll(messages);
        chat.setMessages(messages);

        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateMessages(String message) {
        utterances.add(message);
        chat.setMessages(utterances);

        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateChatbotName(String name) {

    }

    @Override
    public void showNetworkError(String errorMsg) {

    }
}
