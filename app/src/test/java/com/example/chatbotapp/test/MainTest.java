package com.example.chatbotapp.test;

import com.example.chatbotapp.DaggerTestComponent;
import com.example.chatbotapp.ui.main.MainPresenter;
import com.example.chatbotapp.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static com.example.chatbotapp.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(manifest="src/main/AndroidManifest.xml")
public class MainTest {
    @Inject
    MainPresenter mainPresenter;

    private MainScreen mainScreen;

    public MainTest() {
    }

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testLogin() {
        String username = "richard";
        String password = "asd";
        mainPresenter.login(username, password);
        verify(mainScreen).getMessages(username);
    }

    @Test
    public void testRegister() {
        String username = "richard";
        String password = "asd";
        mainPresenter.register(username, password);
        verify(mainScreen).getMessages(username);
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
