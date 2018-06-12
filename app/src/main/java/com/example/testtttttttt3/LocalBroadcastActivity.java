package com.example.testtttttttt3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class LocalBroadcastActivity extends AppCompatActivity {

    private IntentFilter intentFilter = new IntentFilter();
    private  LocalReceiver localReceiver = new LocalReceiver();
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        localBroadcastManager = LocalBroadcastManager.getInstance(this); //获取实例
        intentFilter.addAction("com.example.broadcast.LOCAL_BROADCAST");
        registerReceiver(localReceiver,intentFilter);
        Button button = findViewById(R.id.button9);
        button.setOnClickListener(view -> {
            Intent intent = new Intent("com.example.broadcast.LOCAL_BROADCAST");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    /*
     *本地广播无法静态注册方式来接收，因为静态注册主要就是为了让程序为启动
     *的情况下也能接收广播，而发送本地广播，我们程序肯定启动了
     */
    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
