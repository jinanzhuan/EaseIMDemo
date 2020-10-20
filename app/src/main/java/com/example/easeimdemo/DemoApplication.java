package com.example.easeimdemo;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化环信SDK
        initSDK();
    }

    private void initSDK() {
        //di'
        EMOptions options = new EMOptions();
        EMClient.getInstance().init(this, options);
    }
}

