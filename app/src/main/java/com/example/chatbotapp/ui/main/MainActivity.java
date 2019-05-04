package com.example.chatbotapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chatbotapp.ChatbotApplication;
import com.example.chatbotapp.R;
import com.example.chatbotapp.ui.chat.ChatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {
    public static final String KEY = "KEY";
    @Inject
    MainPresenter mainPresenter;
    private EditText editUsername;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ChatbotApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);

        Button btnLogin = findViewById(R.id.loginButton);
        Button btnRegister = findViewById(R.id.registerButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.login(editUsername.getText().toString(),
                                    editPassword.getText().toString());
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.register(editUsername.getText().toString(),
                                        editPassword.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void getMessages(String username) {
        Intent intent = new Intent(MainActivity.this, ChatActivity.class);
        intent.putExtra(KEY, username);
        startActivity(intent);
    }
}
