package com.example.testtttttttt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testtttttttt3.Adapter.ChatMsgAdapter;
import com.example.testtttttttt3.Bean.ChatMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class ChatActivity extends BaseActivity {

    private List<ChatMessage> messageList = new ArrayList<>();
    private EditText inputEdit;
    private Button rightSend,leftSend;
    private RecyclerView msgRecyclerView;
    private ChatMsgAdapter chatMsgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
        immersionSystemBar();
    }
    private void init(){
        inputEdit = findViewById(R.id.editText_chat_content);
        rightSend = findViewById(R.id.btn_right_send_text);
        leftSend = findViewById(R.id.btn_left_send_text);
        msgRecyclerView = findViewById(R.id.review_chat);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        chatMsgAdapter = new ChatMsgAdapter(getApplicationContext(),messageList);
        msgRecyclerView.setAdapter(chatMsgAdapter);
        rightSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLeftOrRight(ChatMessage.TYPE_SENT);
            }
        });
        leftSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sendLeftOrRight(ChatMessage.TYPE_RECEIVED);
            }
        });
    }
    private void sendLeftOrRight(int type){
        String content = inputEdit.getText().toString();
        if(!"".equals(content)){
            ChatMessage msg = new ChatMessage(content,type);
            messageList.add(msg);
            chatMsgAdapter.notifyItemChanged(messageList.size()-1);
            msgRecyclerView.scrollToPosition(messageList.size()-1);
            inputEdit.setText("");
        }
    }
}
