package com.example.testtttttttt3.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.testtttttttt3.Bean.ChatMessage;
import com.example.testtttttttt3.Bean.Fruit;
import com.example.testtttttttt3.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2018/5/19.
 */

public class ChatMsgAdapter extends RecyclerView.Adapter<ChatMsgAdapter.ViewHolder>{

    private List<ChatMessage> mMessageList;
    public Context mContext;

    static class ViewHolder extends  RecyclerView.ViewHolder{

        LinearLayout leftLayout,rightLayout;

        TextView leftMsg,rightMsg;

        public  ViewHolder(View view){
            super(view);
           leftLayout = view.findViewById(R.id.ll_left);
           rightLayout = view.findViewById(R.id.ll_right);
           leftMsg = view.findViewById(R.id.ll_tv_left_msg);
           rightMsg = view.findViewById(R.id.ll_tv_right_msg);
        }
    }
    public  ChatMsgAdapter(Context context,List<ChatMessage> messageList){
        mContext = context;
        mMessageList = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_chat_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        ChatMessage msg = mMessageList.get(position);
        if(msg.getType() == ChatMessage.TYPE_RECEIVED){
            //如果是接收消息，则显示左边的布局，右边的布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.leftMsg.setText(msg.getContent());
            holder.rightLayout.setVisibility(View.GONE);
        }else if(msg.getType() == ChatMessage.TYPE_SENT){
            //如果是发送消息，则显示右边的布局，左边的布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
            holder.leftLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

}
