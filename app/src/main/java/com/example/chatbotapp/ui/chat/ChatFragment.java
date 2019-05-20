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
import com.google.android.gms.analytics.Tracker;

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
    private List<String> user_utterances;


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
        user_utterances = new ArrayList<String>();
        chat.setMessages(utterances);
        chat.setUser_messages(user_utterances);
        chatAdapter = new ChatAdapter(getContext(), utterances, user_utterances);
        chatView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_utterances.add(editMessage.getText().toString());
                chat.setUser_messages(user_utterances);
                chatAdapter.notifyDataSetChanged();
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
        for (int i=0; i<messages.size(); i++) {
            if (i%2==0) {
                user_utterances.add(messages.get(i));
            }
            else {
                utterances.add(messages.get(i));
            }
        }
        chat.setMessages(utterances);
        chat.setUser_messages(user_utterances);

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
