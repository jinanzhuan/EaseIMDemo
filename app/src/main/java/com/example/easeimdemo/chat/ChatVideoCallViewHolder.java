package com.example.easeimdemo.chat;

import android.view.View;

import androidx.annotation.NonNull;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.interfaces.MessageListItemClickListener;
import com.hyphenate.easeui.model.styles.EaseMessageListItemStyle;
import com.hyphenate.easeui.viewholder.EaseChatRowViewHolder;

public class ChatVideoCallViewHolder extends EaseChatRowViewHolder {

    public ChatVideoCallViewHolder(@NonNull View itemView, MessageListItemClickListener itemClickListener, EaseMessageListItemStyle itemStyle) {
        super(itemView, itemClickListener, itemStyle);
    }

    @Override
    public void onBubbleClick(EMMessage message) {
        super.onBubbleClick(message);
    }
}

