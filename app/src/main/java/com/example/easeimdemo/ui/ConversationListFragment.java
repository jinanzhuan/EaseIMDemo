package com.example.easeimdemo.ui;

import android.view.View;
import android.widget.Toast;

import com.hyphenate.easeui.modules.conversation.EaseConversationListFragment;


public class ConversationListFragment extends EaseConversationListFragment {

    @Override
    public void onItemClick(View view, int position) {
        super.onItemClick(view, position);
        Toast.makeText(mContext, "点击了条目："+position, Toast.LENGTH_SHORT).show();
    }
}

