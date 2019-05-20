package com.example.chatbotapp;

import android.app.Application;

import com.example.chatbotapp.ui.UIModule;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class ChatbotApplication extends Application {

    public static ChatbotApplicationComponent injector;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        sAnalytics = GoogleAnalytics.getInstance(this);
        injector =
                DaggerChatbotApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }

    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
}
