package com.example.easeimdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public BaseActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        initIntent(getIntent());
        initView();
        initListener();
        initData();
    }

    protected abstract int getLayoutId();

    protected void initIntent(Intent intent) {}

    protected void initView() {}

    protected void initListener() {}

    protected void initData(){}
}

