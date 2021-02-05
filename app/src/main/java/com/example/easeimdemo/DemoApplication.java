package com.example.easeimdemo;

import android.app.Application;

import com.example.easeimdemo.chat.ChatTxtNewAdapterDelegate;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseIM;
import com.hyphenate.easeui.delegate.EaseCustomAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseExpressionAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseFileAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseImageAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseLocationAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseTextAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseVideoAdapterDelegate;
import com.hyphenate.easeui.delegate.EaseVoiceAdapterDelegate;
import com.hyphenate.easeui.manager.EaseMessageTypeSetManager;

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
        EaseIM.getInstance().init(this, options);
        EMClient.getInstance().setDebugMode(true);
        registerConversationType();
    }

    /**
     * 注册消息类型
     */
    private void registerConversationType() {
        EaseMessageTypeSetManager.getInstance()
                .addMessageType(EaseImageAdapterDelegate.class)
                .addMessageType(EaseVoiceAdapterDelegate.class)
                .addMessageType(EaseVideoAdapterDelegate.class)
                .addMessageType(EaseLocationAdapterDelegate.class)
                .addMessageType(EaseCustomAdapterDelegate.class)
                .addMessageType(EaseExpressionAdapterDelegate.class)
                .addMessageType(EaseFileAdapterDelegate.class)
                .addMessageType(ChatTxtNewAdapterDelegate.class)
                .setDefaultMessageType(EaseTextAdapterDelegate.class);

    }
}

