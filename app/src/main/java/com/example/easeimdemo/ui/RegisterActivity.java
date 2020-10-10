package com.example.easeimdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easeimdemo.BaseActivity;
import com.example.easeimdemo.R;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_username;
    private EditText et_password;
    private EditText et_password_confirm;
    private Button btn_login;
    private Button btn_goto_register;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_password_confirm = findViewById(R.id.et_password_confirm);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login :
                register();
                break;
            case R.id.btn_goto_register :
                LoginActivity.actionStart(this, "");
                break;
        }
    }

    private void register() {
        new Thread(()-> {
            String username = et_username.getText().toString().trim();
            String password = et_password.getText().toString().trim();
            String passwordConfirm = et_password_confirm.getText().toString().trim();
            try {
                EMClient.getInstance().createAccount(username, password);
                LoginActivity.actionStart(this, username);
            } catch (HyphenateException e) {
                e.printStackTrace();
                runOnUiThread(()-> {
                    Toast.makeText(RegisterActivity.this, "error:"+e.getDescription(), Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }
}

