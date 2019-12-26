package com.example.a21711436.tp2;

import android.app.Application;

public class AppClass extends Application {
    private static AppClass instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppClass getInstance() {
        return instance;
    }
}
