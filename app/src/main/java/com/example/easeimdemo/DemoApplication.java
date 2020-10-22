package com.example.easeimdemo;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化环信SDK
        initSDK();
    }

    private void initSDK() {
        //第二个参数不可以传入null
        EMOptions options = new EMOptions();
        //替换为EaseUI的init
        EaseUI.getInstance().init(this, options);
    }
}

