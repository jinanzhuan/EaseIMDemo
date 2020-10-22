package com.example.easeimdemo.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.easeimdemo.BaseActivity;
import com.example.easeimdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hyphenate.easeui.ui.base.EaseBaseFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navView;
    private EaseBaseFragment mCurrentFragment;
    private EaseBaseFragment mConversationListFragment, mContactListFragment, mHxFragment;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        navView = findViewById(R.id.nav_view);
    }

    @Override
    protected void initListener() {
        super.initListener();
        navView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    private void switchToHome() {
        if(mConversationListFragment == null) {
            mConversationListFragment = new ConversationListFragment();
        }
        replace(mConversationListFragment, "conversation");
    }

    private void switchToContact() {
        if(mContactListFragment == null) {
            mContactListFragment = new ContactListFragment();
        }
        replace(mContactListFragment, "contact");
    }

    private void switchToHuanxin() {
        if(mHxFragment == null) {
            mHxFragment = new AboutHxFragment();
        }
        replace(mHxFragment, "huanxin");
    }

    private void replace(EaseBaseFragment fragment, String tag) {
        if(mCurrentFragment != fragment) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            if(mCurrentFragment != null) {
                t.hide(mCurrentFragment);
            }
            mCurrentFragment = fragment;
            if(!fragment.isAdded()) {
                t.add(R.id.fl_main_fragment, fragment, tag).show(fragment).commit();
            }else {
                t.show(fragment).commit();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_nav_home :
                switchToHome();
                break;
            case R.id.main_nav_contact :
                switchToContact();
                break;
            case R.id.main_nav_me :
                switchToHuanxin();
                break;
        }
        return true;
    }
}