package com.example.chatbotapp.test;

import android.util.Log;

import com.example.chatbotapp.DaggerTestComponent;
import com.example.chatbotapp.interactor.ChatInteractor;
import com.example.chatbotapp.ui.chat.ChatPresenter;
import com.example.chatbotapp.ui.chat.ChatScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static com.example.chatbotapp.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(manifest="src/main/AndroidManifest.xml")
public class ChatTest {
    @Inject
    ChatPresenter chatPresenter;

    private ChatScreen chatScreen;

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        chatScreen = mock(ChatScreen.class);
        chatPresenter.attachScreen(chatScreen);
    }

    @Test
    public void testRefreshChat() {
        chatPresenter.refreshChat("Hello", "richard");

        ArgumentCaptor<String> chatCaptor = ArgumentCaptor.forClass(String.class);
        verify(chatScreen).updateMessages(chatCaptor.capture());
        assertTrue(chatCaptor.getValue().equals("How are you?"));
    }

    @Test
    public void testGetChat() {
        chatPresenter.getChat("richard");

        ArgumentCaptor<List<String>> chatCaptor = ArgumentCaptor.forClass(List.class);
        verify(chatScreen).showMessages(chatCaptor.capture());
    }

    @Test
    public void changeChatbotName() {
        chatPresenter.refreshName("richard","name");
        ArgumentCaptor<String> chatCaptor = ArgumentCaptor.forClass(String.class);
        verify(chatScreen).updateMessages(chatCaptor.capture());
        assertTrue(chatCaptor.getValue().equals("success"));
    }

    @After
    public void tearDown() {
        chatPresenter.detachScreen();
    }

}
