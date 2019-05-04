package com.example.chatbotapp;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        ChatbotApplication application = (ChatbotApplication) RuntimeEnvironment.application;
        ChatbotApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }
}
