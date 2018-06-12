package com.example.testtttttttt3;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testtttttttt3.Util.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class HandlerTestActivity extends AppCompatActivity {
    public TextView mTextView;
    public ImageView img;
    public String requestBingPic = "http://guolin.tech/api/bing_pic";
    public String bingPic;
    // 步骤1：在主线程中 通过匿名内部类 创建Handler类对象
    private Handler mHandler = new Handler(){
        // 通过复写handlerMessage()从而确定更新UI的操作
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                // 根据不同线程发送过来的消息，执行不同的UI操作
                case 1 :
                    mTextView.setText("执行了线程1的UI操作");
                    break;
                case 2:
                    mTextView.setText("执行了线程2的UI操作");
                    break;
                case 3:
//                    loadBingPic();
//                    Glide.with(HandlerTestActivity.this).load(bingPic).into(img);
                    break;
            }
        }
    };

    Button btn,buttonLoadPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        mTextView =  findViewById(R.id.hd_tv);
        img = findViewById(R.id.hd_image);
        btn = findViewById(R.id.hd_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 采用继承Thread类实现多线程演示
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 步骤3：创建所需的消息对象
                        Message msg = new Message();
                        msg.what = 1; // 消息标识
                        // 步骤4：在工作线程中 通过Handler发送消息到消息队列中
                        mHandler.sendMessage(msg);
                    }
                }.start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 通过sendMessage（）发送
                        // a. 定义要发送的消息
                        Message msg = new Message();
                        msg.what = 2; //消息的标识
                        // b. 通过Handler发送消息到其绑定的消息队列
                        mHandler.sendMessage(msg);
                    }
                }).start();
            }
        });

        buttonLoadPicture = findViewById(R.id.hd_load_pic);
        buttonLoadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Message message = new Message();
//                        message.what = 3;
//                        mHandler.sendMessage(message);
//                    }
//                }).start();
                loadBingPic();
            }
        });
    }
    private void loadBingPic(){
        HttpUtil.sendOkHttpRequest(requestBingPic,new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
            bingPic = response.body().string();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Glide.with(HandlerTestActivity.this).load(bingPic).into(img);
                }
            });
            }
        });
    }
}
