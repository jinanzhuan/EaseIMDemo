package com.example.easeimdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easeimdemo.BaseActivity;
import com.example.easeimdemo.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_goto_register;
    private String username;

    public static void actionStart(Context context, String username) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("username", username);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initIntent(Intent intent) {
        super.initIntent(intent);
        username = intent.getStringExtra("username");
    }

    @Override
    protected void initView() {
        super.initView();
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_goto_register = findViewById(R.id.btn_goto_register);
    }

    @Override
    protected void initListener() {
        super.initListener();
        btn_login.setOnClickListener(this);
        btn_goto_register.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        if(!TextUtils.isEmpty(username)) {
            et_username.setText(username);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login :
                login();
                break;
            case R.id.btn_goto_register :
                RegisterActivity.actionStart(this);
                break;
        }
    }

    private void login() {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        EMClient.getInstance().login(username, password, new EMCallBack() {
            @Override
            public void onSuccess() {
                MainActivity.actionStart(LoginActivity.this);
            }

            @Override
            public void onError(int i, String s) {
                runOnUiThread(()-> {
                    Toast.makeText(LoginActivity.this, "error = "+s, Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}

