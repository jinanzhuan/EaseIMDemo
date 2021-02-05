package com.example.easeimdemo.chat;

import android.content.Context;
import android.widget.TextView;

import com.example.easeimdemo.R;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.easeui.widget.chatrow.EaseChatRow;

public class ChatRowTxtNew extends EaseChatRow {
    private TextView contentView;

    public ChatRowTxtNew(Context context, boolean isSender) {
        super(context, isSender);
    }

    @Override
    protected void onInflateView() {
        inflater.inflate(isSender ? R.layout.ease_row_sent_txt_new : R.layout.ease_row_received_txt_new, this);
    }

    @Override
    protected void onFindViewById() {
        contentView = (TextView) findViewById(com.hyphenate.easeui.R.id.tv_chatcontent);
    }

    @Override
    protected void onSetUpView() {
        EMTextMessageBody txtBody = (EMTextMessageBody) message.getBody();
        contentView.setText(txtBody.getMessage());
    }
}

