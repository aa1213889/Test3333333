package com.example.testtttttttt3.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/19.
 */

public class ChatMessage implements Serializable {

    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SENT = 1;

    private String content;

    private int type;

    public ChatMessage(String content,int type){
        this.content = content ;
        this.type = type ;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

}
